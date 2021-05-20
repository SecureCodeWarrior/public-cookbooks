## Adding Parameters to Annotations Using Rewrite Actions

In this example, we will:

- Demonstrate searching and matching annotations.
- Amend annotations using mustache templates.

Sensei provides the ability to match problematic code patterns and then amend them to agreed implementations. In this example I am using `@Disabled` without a parameter as the problematic code pattern.

## See This In Action on YouTube

[![](https://i.ytimg.com/vi/mjXGliXJ7M8/hqdefault.jpg)](https://www.youtube.com/watch?v=mjXGliXJ7M8)

## Disabled Test Annotation

Disabled tests without a specified reason can prove problematic over the long term
because we forget why we disabled it.

```
@Disabled
void thisTestMethodHasNoDisabledReason(){
    Assertions.fail("This test is disabled and should not run");
}
```

The risk is that, over time, the code base moves on, the disabled test is not updated in step with the purpose of the code and eventually becomes redundant and irrelevant, and potentially never re-enabled.

During code reviews, we will often point out that it is a good idea to add an explanatory description as the annotation parameter.

```
@Disabled("Disabled to demonstrate adding a reason")
void thisTestMethodHasDisabledReason(){
    Assertions.fail("This test is disabled and should not run");
}
```

## A Sensei Recipe

We can write a recipe to detect when `@Disabled` is added without explanation and a Quick Fix that reminds us to add the actual reason explaining why we disabled it.

### Task

When I think about what I'm going to do, I have to:

- match the `Disabled` annotation without any parameters
- change the `Disabled` annotation to have a parameter with marker text "TODO: add a description here"


### Solution

I use `Alt+Enter` to Create a new Recipe and add the basic descriptive text in the general information.

General:

~~~~~~~~
name: remember to add disabled description
short description: @Disabled should really have a description explaining why
Level: Error
~~~~~~~~

In the recipe editor, I change the Search to match an annotation.

This will highlight all annotations in the preview.

Having done that, I want to filter on the `type`. I could just use `Disabled` but I fully qualify the class with the package so that it only matches the annotation from JUnit 5. Because the preview is displayed, I can easily copy and paste this from the code.

I then want to match only annotations without Parameters, and I can use the GUI to do that.

i.e. Search:

~~~~~~~~
search:
  annotation:
    type: "org.junit.jupiter.api.Disabled"
    without:
      parameters:
      - {}
~~~~~~~~

For my QuickFix I will use a rewrite action.

I use the `Show Variables` functionality to show me the Mustache variables and preview the contents. And then I add the extra code needed to create the place marker comment.

i.e. QuickFix:

~~~~~~~~
availableFixes:
- name: "Add a todo comment parameter"
  actions:
  - rewrite:
      to: "{{{ . }}}(\"TODO: add a description here\")"
      target: "self"
~~~~~~~~

## Summary

When building a rewrite Quick Fix, it is easier when we can search for the code element that we want to rewrite, because it is then the `self` entity we can act on.

In this example, I used a rewrite action to amend the Annotation. Rewrite is a general-purpose action that can apply to any code element and is a good default to explore.