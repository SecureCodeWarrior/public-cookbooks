# Amending Method and Class Visibility for JUnit 5

One of the joys of programming is the constant learning required to keep up to date. One of the issues is that we build up familiarity and patterns of usage that can impact the adoption of new approaches. Sensei can help migration by identifying deprecated patterns and prompting us with the fix to use going forward.

As an example, when I migrated from JUnit 4 to JUnit 5, I was used to writing all my test classes and methods as `public`. But with JUnit 5 they can be `package private`.

e.g. instead of:

```
public class Junit5VisibilityTest {

    @Test
    public void thisDoesNotNeedToBePublic(){
        Assertions.assertTrue(true);
    }
}
```

I really want to write:

```
class Junit5VisibilityTest {

    @Test
    void thisDoesNotNeedToBePublic(){
        Assertions.assertTrue(true);
    }
}
```

It took me a while to build the muscle memory to code to this, and I still slip up once in a while.

## Using Sensei

With Sensei I can create recipes that find the `public` methods and classes, and amend the declarations to be `package private` automatically.

To achieve this I created a recipe:

```
Name - JUnit: JUnit 5 test methods do not need to be public
Description - JUnit 5 test methods do not need public visibility
Level - Error
```

I classed it as `Error` because I want to stamp out this coding practice and I want  higher visibility of the issue when I'm writing code in the IDE.

## Amending the Class Declaration

To find the classes, I search for any class which has a child annotation of `@Test` from Junit 5 i.e. `org.junit.jupiter.api.Test`

And where the class has modifier `public`:

```
search:
  class:
    with:
      child:
        annotation:
          type: "org.junit.jupiter.api.Test"
    modifier: "public"
```

Then the quick fix changes the modifier to remove the visibility so that it is the default, and the default is `package private` which is what I'm looking for.

```
availableFixes:
- name: "remove public visibility from JUnit 5  Test class"
  actions:
  - changeModifiers:
      visibility: ""
```

## Amending the Method Declarations

The method declaration amendment recipe is much the same as the class recipe.

First I search for `public` methods annotated with `@Test` from JUnit 5.

```
search:
  method:
    annotation:
      type: "org.junit.jupiter.api.Test"
    modifier: "public"
```

And then I change the modifier to be default visibility.

```
availableFixes:
- name: "Remove @Test method public visibility"
  actions:
  - changeModifiers:
      visibility: ""
```

## Hint: Amending Multiple Methods

Sensei has the ability to apply the QuickFix to all the violations in the current file.

When I use `alt+enter` to apply the QuickFix.

If I expand the QuickFix name menu, I can see an option to:

"Fix All: 'JUnit: JUnit 5 test methods do not need to be public' problems in the file"

When I select that option then Sensei will amend all the occurrences of the problem, not just the one I select.

## Amending the class

In the same way that a method does not need to be public, neither does the class.

I can create a recipe and a QuickFix to amend the class.

```
Name - JUnit: Junit 5 Test classes do not need to be public
Description - Junit 5 Test classes do not need to be public
Level - Error
```

When I find a class that is `public` and has a method with a `@Test` annotation. Then I want to change the visibility.

```
search:
  class:
    modifier: "public"
    anyOf:
    - child:
        method:
          annotation:
            type: "Test"
```       

I can make the change to the class definition with the `changeModifiers` action again.

```
availableFixes:
- name: "Remove @Test class public visibility"
  actions:
  - changeModifiers:
      visibility: ""
```

## Summary

A static analysis tool initially alerted me to this recommended approach in JUnit. But the static analysis tool didn't help me build the muscle memory to change my code as I program.

Use the 'Level' to alert you. When it is a problem I am trying to stamp out in my coding I initially make it 'Error' and then reduce this as I wean myself off the coding approach.

Remember you can use Sensei to fix all the issues in the current file at the same time, by using the drop-down menu option when applying the QuickFix.

By creating a Sensei recipe, I can see my old coding approach in real-time. And QuickFix it, to reinforce the approach if I occasionally slip up in my coding.