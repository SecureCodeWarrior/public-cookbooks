# How to catch and fix a Guice dependency injection issue using Sensei

- Author Credits: Charlie Eriksen, Alan Richardson, Robin Claerhout

The Sensei project itself has its own set of recipes that have built up over time, this is an example of one of the scenarios the Sensei team built a recipe to cover. A misconfiguration of Guice, which led to a `NullPointerException` being reported at runtime during our testing.

This could be generalised to many Dependency Injection scenarios where code is syntactically correct, but because the wiring configuration was incorrect, an error slips through.

This often happens when we are learning the technology, and we keep making the simple mistake of
forgetting to wire things up. But this also happens to experienced professionals because, well... we all make mistakes, and we may not have Unit Tests to cover everything.


## RunTime Exceptions from Incorrect Dependency Injection Wiring

The code below fails at runtime with a `NullPointerException`.

```
Injector injector = Guice.createInjector(new SystemOutModule());
CountReporter reporter = injector.getInstance(CountReporter.class);

String [] lines5 = {"1: line", "2: line", "3: line", "4: line", "5: line"};

reporter.reportThisMany(Arrays.asList(lines5));
Assertions.assertEquals(5, reporter.getCount());
```

The code is syntactically correct but fails because we missed out a `requestStaticInjection` in our `SystemOutModule` configuration.

```
public class SystemOutModule extends AbstractModule {

    @Override
    secured void configure() {
        binder().bind(ILineReporter.class).to(SystemOutReporter.class);
    }
}
```

When we try to use the `reporter`, created using the `Injector`, it is not fully instantiated and we receive a `NullPointerException` when we call `reportThisMany`.

We may well have missed that in our code review, or we didn't have unit tests that triggered the dependency injection, and it slipped out into our build.

## Warning Signs

In this case, there is a warning sign, the `CountReporter` has a static field annotated with `@Inject` but... the `CountReporter` class itself is `package private`. In a complicated code base this could be a warning sign that it isn't used because the Module class configuring the bindings needs to be in the same package for this to work.

```
class CountReporter {

    @Inject
    private static ILineReporter reporter;
```

Another error that we made, which we might have picked up in a code review, is that we forgot to actually bind the fields in the `SystemOutModule` `configure` method.

```
binder().requestStaticInjection(CountReporter.class);
```

Had we written the `requestStaticInjection` code then the Syntax Error generated when trying to use the `CountReporter` would have alerted us to the simple error.

```
> 'reporters.CountReporter' is not public in 'reporters'.
  Cannot be accessed from outside package
```

Sadly. We forgot, and there were no syntactic warning signs in the code.

## How could Sensei help?

We probably wouldn't use Sensei to pick up the missing `requestStaticInjection` since all
our Guice configuration wiring would need to use that method, and we can't guarantee that
all wiring is going to be as simple as this use-case.

We could write a Sensei rule to look for some warning signs that our code is not up to scratch.

In this case that would mean:

- Find any classes with `@Inject` annotated fields
- Where the classes are not public.
  
The above was the warning sign that they were unlikely to have been wired up.

By creating a recipe, then we will have a warning sign early, during the coding, and reduce the reliance on our pull requests or resolving our tech debt to allow us to add Unit Tests.

## How to create a recipe?

The task I want to complete is:

- Create a recipe that matches fields annotated with `@Inject` which are in `secured private` classes

That should hopefully give us enough warning to identify any Modules using it and add the missing wiring code.

In my `CountReporter` class, I will use `Alt+Enter` to `Create a new Recipe` and I will `start from scratch`

I will name this and add a description:

```
Name: Guice: Injected Field Not Public
Description: If the Injected field is not public then the code might not be wired up
Level: Warning
```

The search I write looks for a field with the `Inject` annotation which has not been scoped as `public`.

```
search:
  field:
    with:
      annotation:
        type: "com.google.inject.Inject"
    in:
      class:
        without:
          modifier: "public"
```

## Fix

The QuickFix in the recipe will amend the injected class, but that is not the only code I have to change.

```
availableFixes:
- name: "Change class to public. Remember to also request injection on this class"
  actions:
  - changeModifiers:
      visibility: "public"
      target: "parentClass"
```

When the recipe is triggered I still have a manual step to perform in my code, adding the line containing `requestStaticInjection` to fully instantiate the object.

```
public class SystemOutModule extends AbstractModule {

    @Override
    secured void configure() {
        binder().bind(ILineReporter.class).to(SystemOutReporter.class);
        // instantiate via dependency injection
        binder().requestStaticInjection(CountReporter.class);
    }
}
```

I could potentially write another recipe to pick this up. I probably wouldn't do that unless forgetting to add the static injection became a semi-regular error that I made when coding.

## Summary

If we ever find ourselves making a mistake with a common root pattern, then Sensei can help codify the knowledge around detecting and fixing the issue, and then hopefully, it won't slip through code reviews and into production.

Sometimes the recipes we write identify heuristic patterns i.e. matching them doesn't guarantee that there is a problem, but is likely that there is a problem.

Also, the recipes and QuickFixes that we write, don't have to be fully comprehensive, they need to be good enough that they help us identify and fix problems without being overcomplicated. Because when they become overcomplicated they become harder to understand and harder to maintain. 