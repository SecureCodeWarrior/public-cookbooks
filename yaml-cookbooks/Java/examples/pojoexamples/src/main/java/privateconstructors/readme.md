# Adding a Private Constructor

In a utility class, when the fields and methods are static, there is no obvious reason why I would ever instantiate it.

e.g. `UtilityClass utility = new UtilityClass();`

The code below is a simple implementation of a Utility class.

~~~~~~~~
public class UtilityClass {

    public static final Boolean ULTIMATE_TRUTH = true;

    public static boolean getTrue(){
        return ULTIMATE_TRUTH;
    }
}
~~~~~~~~

This is the type of coding pattern that Static Analysis tools can pick up, but they often don't supply the ability to fix the issue.

I can use Sensei to identify the coding pattern, and automatically generate a private constructor to make it impossible for me to instantiate the class.

Now that I know I can fix the problem. I’ll refine the search conditions to show the recipe when it is most appropriate.

## Searching for the Class

I create a new recipe on the Utility class called `Static Classes: create private constructor`.

```
Name: Static Classes: create private constructor
Description: create a private constructor for static classes
Level: Error
```

And initially I'll search for a class.

~~~~~~~~
search:
  class: {}
~~~~~~~~

This will match any class, which is good enough to let me get started writing a `Quick Fix`, and once I have a `Quick Fix` that works, I'll refine the search to make it highlight when there is more likely to be a class that requires a private constructor.

## Quick Fix

For the Quick Fix, I will want to generate a private constructor.

In the example class this would look like:

~~~~~~~~
    private UtilityClass(){}
~~~~~~~~

To add the above code to my class, my Quick Fix will add a Method, and the name of the method will be a Mustache template that uses the name of the class.

~~~~~~~~
availableFixes:
- name: "add private constructor"
  actions:
  - addMethod:
      method: "private {{{ name }}}(){}"
~~~~~~~~

In the GUI Editor, I use the `Show Variables` to create the Mustache template and then edit the field to add the `private` modifier, brackets, and braces to make it syntactically correct.

And this would now allow me to add a private constructor to any class.

The QuickFix preview helps me because I can see the generated code as I write the Mustache template.

## Search for Missing Constructors

Ideally, I don't want to create a recipe that flags an error against every class. So I'll add some additional conditions in the search so that we only match on classes that do not have a constructor.

~~~~~~~~
search:
  class:
    without:
      child:
        method:
          constructor: true
~~~~~~~~

The YAML is slightly different from the GUI.

In the GUI I configure it to look for a class without a child method which is a constructor 'yes'. We use 'yes' in the GUI instead of 'true' to make the GUI a little more human friendly.

This recipe will now only reveal itself for any class without a constructor.

## Narrow Search for Likely Culprits

So I might want to go further and look for the presence of static methods or fields.

I look for any class without a constructor and which has either all public static fields or all public static methods.

~~~~~~~~
search:
  class:
    with:
      anyOf:
      - child:
          method:
            allOf:
            - modifier: "public"
            - modifier: "static"
      - child:
          field:
            allOf:
            - modifier: "static"
            - modifier: "public"
    without:
      child:
        method:
          constructor: true
~~~~~~~~

Since Sensei is used to help me, as a  programmer, in the IDE, rather than to statically analyze the code and report all errors, this filter is good enough to rule out most classes in my code base where I might have a good reason to have a default public constructor.

In some projects, this might be a step too far because the utility classes could have private methods, so I might choose to look for the presence of 'any' `public static` methods, rather than 'all'.

~~~~~~~~
        - child:
            field:
              anyOf:
                - modifier: "static"
                - modifier: "public"
~~~~~~~~

## Hints

Sensei is not designed to replace a Static Analysis tool. Sensei can augment a Static Analysis tool for common issues associated with your coding process, or technology. By replicating enough of the matching to highlight an issue, and supporting the development process by generating the QuickFix code.

What I'm trying to do is create a simple enough recipe that includes all the situations I need it, but filter it so that it doesn't get suggested in every class.

When working on recipes I try to de-risk them, in this case, I wasn't sure if I could create the private constructor so I created the QuickFix first. Then refactored the search conditions to make them more specific.

Sometimes when working on recipes I'm not sure how to perform the search, so I work on that first.

I find recipes easier to create when I build them incrementally, switching between refactoring of the QuickFix and the search.
