# Documentation Links

One of the difficulties with learning a new library, or sharing agreed practices across our team is documenting and creating examples.

Very often we create small example projects, but we don't have them open when working with actual code.

I've often thought it would be great to have the ability to link to our examples, or online examples and be able to goto a URL for more explanation when needed.

With Java, we have JavaDoc comments, which can have a `see` annotation:

```
/**
 * @see <a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations">Junit 5 Annotation docs</a>
 */
```

JavaDoc like this in 3rd party libraries is a great help because we can use the `Quick Documentation` functionality in IntelliJ to have access to more detailed examples. 

But, we all know that comments don't get updated as often as code, and web presence maintenance is often disconnected from library maintenance and sometimes performed by a different team entirely.

## How Sensei Helps

Sensei provides the ability to match on library annotations and methods to provide links to long form documentation on a wiki or third party tutorial site.

As an example, I'm using the `@Test` annotation from JUnit.
     
The JavaDoc is very detailed, and the `Quick Documentation` view explains how to use the annotation.

But the official documentation on the web site is often easier to read and has more examples.

When a team starts learning a library, having a set of recommended tutorials, can be very useful.

Sensei has a `goto` action that can open a URL, allowing us to link to external sites and examples for documentation that we, as a team, find useful.      
        
## Implementing the Goto URL        
        
To implement this I would create a search that matches the `@Test` annotation from Junit.        

```
search:
  annotation:
    owner:
      method: {}
    type: "org.junit.jupiter.api.Test"
```

And then I would add `goto` actions for each of the URLs I find useful.

e.g.

- https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations
- https://junit.org/junit5/docs/current/user-guide/#writing-tests-classes-and-methods


The example below would create a single Action `JUnit Annotations (learn)` which would open both URLs in a browser at the same time.

```
availableFixes:
- name: "Learn about JUnit Annotations"
  actions:
  - goto:
      type: "URL"
      value: "https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations"
  - goto:
      type: "URL"
      value: "https://junit.org/junit5/docs/current/user-guide/#writing-tests-classes-and-methods"
```

## Multiple Actions

I might choose to have multiple Actions so that each URL or tutorial has its own option in the `alt+enter` Quick Fix pop up menu.

For example, for the `@Parameterized` annotation, I might want to link to the official documentation and a set of online example code.

- https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests
- https://github.com/eviltester/junitexamples/blob/master/src/test/java/parameterized/junit5/InitialExampleTest.java

I would simply create a recipe that searches for the annotation:

```
search:
  annotation:
    owner:
      method: {}
    type: "org.junit.jupiter.params.ParameterizedTest"
```

And links off to the sites I identified as being useful:

```
availableFixes:
- name: "JUnit Annotations (learn)"
  actions:
  - goto:
      type: "URL"
      value: "https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations"
- name: "What is a JUnit Test? (learn)"
  actions:
  - goto:
      type: "URL"
      value: "https://junit.org/junit5/docs/current/user-guide/#writing-tests-classes-and-methods"
```

Both links would then appear in the pop-up dialog.

## Who would benefit?

I would have found this useful when using and learning libraries, especially when leading teams and helping them adopt a new library.

This could also benefit teams creating libraries, by creating a standard set of documentation recipes to help guide people through the adoption of the library or new features in the library.

This would be especially useful if the code maintenance and documentation maintenance are performed by different teams.