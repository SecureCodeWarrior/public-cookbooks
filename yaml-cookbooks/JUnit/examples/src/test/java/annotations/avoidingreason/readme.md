# Improving A Personal Programming Process Using Sensei

For this post, I've recreated a 'bad' coding approach that I used when I was learning JUnit, and will demonstrate how to convert the ‘bad’ pattern to an agreed, and "better", coding pattern using Sensei.

When I was learning JUnit, I could only keep so much in my head at any one time. I constantly forgot how to skip tests when they were not working.

If we are working in a Team then we can use code reviews on pull requests to help enforce coding styles. And we can shorten the feedback cycle when pair programming with a more experienced programmer.

We can also augment our process with tooling and have the tools prompt us to do the right thing. Thoughtworks describe this as "tools over rules," in their [Technology Radar listing for Sensei](https://www.thoughtworks.com/radar/tools/sensei):

>"make it easy to do the right thing over applying checklist-like governance rules and procedures"

## Disabling a JUnit Test

Ideally, I would, as we all know, use the `@Disabled` annotation and write:

~~~~~~~~
    @Disabled
    @Test
    void canWeAddTwoNumbers(){
        Assertions.fail("this test was skipped and should not run");
    }
~~~~~~~~

But, when learning, I had to train myself to use `@Disabled`.

When I forgot how to disable a Test method I would remove the `@Test` annotation and rename the test: 

~~~~~~~~
class SkipThisTest {

    void SKIPTHIScanWeAddTwoNumbers(){
        Assertions.fail("this test was skipped and should not run");
    }   
}
~~~~~~~~

It wasn't good, but it got the job done. I didn't have something like Sensei to help me remember and so I fell into using poor coding patterns.

The tasks I've taken on board for this readme are to:

- Create a rule which finds methods that have been 'skipped' or 'disabled' by renaming the method.
- Create a QuickFix to rename the method and add both an @Test and @Disabled annotation.


## Recipe Settings

The first step I take with Sensei is to "Create a new recipe" and search for the coding pattern I want the recipe to act on.

```
Name: JUnit: Make @Disabled @Test from SKIPTHIS
Short Description: Stop naming methods SKIPTHIS, use @Disabled @Test instead
```

And my search is very simple. I use a basic regex to match  the method name.

~~~~~~~~
search:
  method:
    name:
      matches: "SKIPTHIS.*"
~~~~~~~~


## QuickFix Settings

The QuickFix is a little more complicated because it will rewrite the code, and I'll use a few steps to achieve my final code.

I want to:

- add an `@Test` annotation to the method
- add an `@Disabled` annotation to the method
- amend the method name

Adding the annotations is simple enough using the `addAnnotation` fix. If I use a fully qualified name for the annotation then Sensei will automatically add the imports for me.

~~~~~~~~
availableFixes:
- name: "Add @Disabled and @Test Annotation"
  actions:
  - addAnnotation:
       annotation: "@org.junit.jupiter.api.Test"
  - addAnnotation:
      annotation: "@org.junit.jupiter.api.Disabled"
~~~~~~~~

The actual renaming seems a little more complicated but I'm just using a regex replacement, and the generic way to do this with Sensei is to use `sed` in a rewrite action.

Because the rewrite actions a Mustache templates, Sensei has so functional extensions in the template mechanism. A function is represented with `{{#...}}` so for `sed` the function is `{{#sed}}`. The function takes two arguments which are comma-separated.

The first argument is the `sed` statement:

- `s/(.*) SKIPTHIS(.*)/$1 $2/`

The second argument is the String to apply the `sed` statement to, which in this case is the method itself, and this is represented in the Mustache variables as:

- `{{{.}}}`

~~~~~~~~
  - rewrite:
       to: "{{#sed}}s/(.*) SKIPTHIS(.*)/$1 $2/,{{{.}}}{{/sed}}"
~~~~~~~~

The `sed` implementation requires that when the arguments themselves contain commas, that they are wrapped with `{{#encodeString}}` and `{{/encodeString}}`
    - e.g. `{{#encodeString}}{{{.}}}{{/encodeString}}`

## Reverse Recipe

Since this is an example, and we might want to use this in demos, I wanted to explore how to reverse out the above change using a Sensei recipe.

Thinking it through I want to find a method annotated with `@Disabled`
but only in the class `SkipThisTest` where I do the demo:

```
Name: JUnit: demo in SkipThisTest remove @Disabled and revert to SKIPTHIS
Short Description: remove @Disabled and revert to SKIPTHIS for demo purposes in the project
Level: warning
```

The Recipe Settings Search is very simple, matching the annotation in a specific class.

~~~~~~~~
search:
  method:
    annotation:
      type: "Disabled"
    in:
      class:
        name: "SkipThisTest"
~~~~~~~~

To avoid making the code look like it is an error I defined the general setting on the recipe to be a Warning. Warnings are shown with highlights in the code and it doesn't make the code look like it has a major problem.

For the Quick fix, since we have matched the method, I use the rewrite action and populate the template using the variables.

~~~~~~~~
availableFixes:
- name: "Remove Disabled and rename to SKIPTHIS..."
  actions:
  - rewrite:
      to: "{{{ returnTypeElement }}} SKIPTHIS{{{ nameIdentifier }}}{{{ parameterList\
        \ }}}{{{ body }}}"
~~~~~~~~

I basically add every variable except the modifier (since I want to get rid of the annotations) and add the `SKIPTHIS` text into the template.

This fix has the weakness that by removing the modifiers, I remove any other annotations as well.

## Add another Action

I can add another named fix, to give me a choice when the `alt+enter` is used to display the QuickFix.

~~~~~~~~
availableFixes:
- name: "Remove Disabled and rename to SKIPTHIS..."
  actions:
  - rewrite:
      to: "{{{ returnTypeElement }}} SKIPTHIS{{{ nameIdentifier }}}{{{ parameterList\
        \ }}}{{{ body }}}"
      target: "self"
- name: "Remove Disabled, keep other annotations, and rename to SKIPTHIS..."
  actions:
  - rewrite:
      to: "{{#sed}}s/(@Disabled\n.*@Test)//,{{{ modifierList }}}{{/sed}}\n\
        {{{ returnTypeElement }}} SKIPTHIS{{{ nameIdentifier }}}{{{ parameterList\
        \ }}}{{{ body }}}"
      target: "self"
~~~~~~~~

Here, I added an additional line in the new Quick Fix.

~~~~~~~~
{{#sed}}s/(@Disabled\n.*@Test)//,{{{ modifierList }}}{{/sed}}
~~~~~~~~

This takes the modifier list, encodes it as a string, then uses `sed` to remove the line with `@Disabled` from the string, but leaves all other lines in the modifier, i.e. it leaves all other annotations alone.

_NOTE: Remember to add the "," in the `sed`, otherwise you will see a comment added to your preview because this is how Sensei alerts you to syntax errors in the `sed` command._

## Nested `sed` calls

I was lucky that I could match both the `@Disabled` and `@Test` in a single search and replace.

In the event that the code is more complicated and I wanted to have a sequence of sed commands then I can do that by nesting them:

```
{{#sed}}s/@Test//,{{#sed}}s/@Disabled\n//,{{{ modifierList }}}{{/sed}}{{/sed}}
```

In the above example, I apply the `@Test` replacement to the results of applying the `@Disabled` replacement on the `{{{ modifierList }}}`.


## Summary

`sed` is a very flexible way to achieve code rewriting and it is possible to nest the `sed` function calls for complicated rewrite conditions.

Recipes like this often end up being temporary because we are using them to improve our programming process, and once we have built up the muscle memory and no longer use the poor programming pattern we can remove or disable them in the Cookbook.



_NOTE: Rather than add two available fixes, I could clone the recipe, but if I do, then I have to remember to uncheck the "Add disable entry for cloned recipe" checkbox, otherwise only the cloned recipe will be available for use._
