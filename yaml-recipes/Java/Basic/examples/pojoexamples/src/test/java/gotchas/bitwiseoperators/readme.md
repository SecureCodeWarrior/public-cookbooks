# Java Gotchas - Bitwise vs Boolean Operators

> "Java Gotcha" - a common mistake pattern that is easy to accidentally implement.

A fairly simple Java Gotcha to accidentally fall into is: using a Bitwise operator instead of a Boolean Comparison operator.

e.g. a simple mistype can result in writing "&" when you really meant to write "&&".

A common heuristic we learn when reviewing code is:

> "&" or "|" when used in a conditional statement is probably not intended.
 
In this example we will explore this heuristic a little and identify ways we can identify and fix this.

## What's the Problem? Bitwise operations work fine with Booleans

Using Bitwise operators with Booleans is perfectly valid, so Java will not report a syntax error.

If I construct a JUnit Test to explore a truth table for both Bitwise OR (`|`) and Bitwise AND (`&`) then we will see that the outputs from the Bitwise operator match the truth table. Given this we might think that the use of Bitwise operators is not an issue.

### AND Truth Table

```
    @Test
    void bitwiseOperatorsAndTruthTable(){
        Assertions.assertEquals(true, true & true);
        Assertions.assertEquals(false, true & false);
        Assertions.assertEquals(false, false & true);
        Assertions.assertEquals(false, false & false);
    }
```

### OR Truth Table

```
    @Test
    void bitwiseOperatorsOrTruthTable(){
        Assertions.assertEquals(true, true | true);
        Assertions.assertEquals(true, true | false);
        Assertions.assertEquals(true, false | true);
        Assertions.assertEquals(false, false | false);
    }
```

see truth tables https://web.stanford.edu/class/cs103/tools/truth-table-tool/

## Issue: Short Circuit Operation

The real issue is the difference in behaviour between Bitwise (`&`, `|`) and Boolean (`&&`, `||`) operators.

A Boolean operator is a short circuit operator, and only evaluates as much as it needs to.

e.g.

```
if (args != null & args.length() > 23) {
    System.out.println(args);
}
```

In the above code, both boolean conditions will evaluate, because the Bitwise operator has been used:

- `args != null`
- `args.length() > 23`

This leaves my code open to a `NullPointerException` if `args` is `null` because we will always perform the check for `args.length`, even when `args` is `null` because both boolean conditions have to be evaluated.


## Boolean Operators Short Circuit Evaluation

When an `&&` is used e.g.

```
if (args != null && args.length() > 23) {
    System.out.println(args);
}
```

As soon as we know that `args != null` evaluates to `false` the condition expression evaluation stops.

We don't need to evaluate the right-hand side.

Whatever the outcome of the right-hand side condition, the final value of the Boolean expression will be false.

## But this would never happen in production code

This is a pretty easy mistake to make, and is not always picked up by Static Analysis tools.

I used the following Google Dork to see if I could find any public examples of this pattern:

`filetype:java if "!=null & "`

This search brought back some code from Android in the `RootWindowContainer`

```
isDocument = intent != null & intent.isDocument()
```

This is the type of code that might pass a code review because we often do use Bitwise operators in assignment statements to mask values. But in this instance the outcome is the same as the `if` statement example above. If `intent` is ever null, then a `NullPointerException` will be thrown.

Very often we get away with this construct because we often code defensively and write redundant code. The check for `!= null` may well be redundant in most use cases.

This is an error made by programmers in production code.

I don't know how current the results for the search are, but when I ran the search there were results back with code from: Google, Amazon, Apache... and me.

A recent [pull request](https://github.com/eviltester/thingifier/pull/8/commits/5134461d7eb2e2208e421990e15b943ba3fd4b6d) on one of my open source projects was to address exactly this error.

```
if(type!=null & type.trim().length()>0){
    acceptMediaTypeDefinitionsList.add(type.trim());
}
```

## How to Find This

When I checked my sample code in a few static analysers, none of them picked up this hidden self-destruct code.

As a team at Secure Code Warrior we created and reviewed a fairly simple Sensei recipe that could pick this up.

Because Bitwise operators are perfectly valid, and often used in assignments we focussed on the use-case of `if` statements, and the use of Bitwise `&`, to find the problematic code.

```
search:
  expression:
    anyOf:
    - in:
        condition: {}
    value:
      caseSensitive: false
      matches: ".* & .*"
```

This uses a regular expression to match `" & "` when it is used as a condition expression. e.g. in an `if` statement.

To fix it, we again relied on regular expressions. This time using the `sed` function in the QuickFix to globally replace the `&` in the expression with `&&`.

```
availableFixes:
  - name: "Replace bitwise AND operator to logical AND operator"
    actions:
      - rewrite:
          to: "{{#sed}}s/&/&&/g,{{{ . }}}{{/sed}}"
```

## End Notes

This covers the most common misuse of Bitwise operator, that is, when a Boolean operator was actually intended.

There are other situations where this could crop up e.g. the assignment example, but when writing recipes we have to attempt to avoid false positive identification, otherwise recipes will be ignored or turned off. We build recipes to match the most common occurrences. As Sensei evolves, we may well add additional specificity into the search functionality to cover more matching conditions.

In its current form, this recipe would identify many of the live use-cases, and _most importantly_, the one that was reported in my project.

> _NOTE: A fair few code warriors contributed to this example and recipe review - Charlie Eriksen, Matthieu Calie, Robin Claerhaut, Brysen Ackx, Nathan Desmet, Downey Robersscheuten. Thanks for your help._

