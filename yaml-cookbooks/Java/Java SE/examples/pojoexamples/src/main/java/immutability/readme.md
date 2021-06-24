## Immutability With Sensei

Some basic steps to creating an immutable class:

- Make constructors private and use factory methods to create objects.
- Make fields `final`, forcing them to be instantiated in a constructor.
- Make class `final`.

Some of the basic principles of immutability are easy to adopt and Static Analysis tooling can help enforce and remind us to think about adopting those principles.

In this section we will explore some simple transformations we can use to convert a mutable class to an immutable class.

While it would be tempting to try and create a single recipe 'this class is mutable - fix it to be immutable'. Such a recipe would be hard to build and maintain. It is often easier to create smaller recipes to handle intermediate step transformations, and allow the programmer to make decisions about which steps to apply, rather than trying to cram a lot in an single recipe.

Try these recipes on the `mutable` classes or when using the `AbuseOpenCoordinates` in the test folder's `immutability.exercise` package.

### Make class `final`

A simple immutable class can be impacted if we can extend it.

Making it `final` can help prevent that.

**Before:**

```
public class MutableCoordinates {
```

**After:**

```
public final class MutableCoordinates {
```

#### Sensei Recipe to Make class `final`

To warn me about this, and create a QuickFix action to help fix it I can use Sensei as follows:

```
Name - Immutable: use final classes to prevent extension
Description - Make the classes final to prevent extension with a mutable subclass
Level - Warning
```

**Recipe Settings:**

```
search:
  class:
    allOf:
    - modifier: public
    without:
      modifier: final
```


**QuickFix:**

```
availableFixes:
- name: "Remove public modifier and make final"
  actions:
  - changeModifiers:
      final: true
```


### Make constructors private and use static factory methods

**Before:**

```
    private int x;
    private int y;

    public Coordinates(){
        x=0;
        y=0;
    }
```

**After:**

```
    private int x;
    private int y;

    private Coordinates(final int x, final int y ){
        this.x=x;
        this.y=y;
    }

    public final static Coordinates create(final int x, final int y ){
        return new Coordinates(x, y );
    }
```


#### Make constructors private and use static factory methods with a Sensei Recipe

```
Name - Immutable: default constructor should set field values from parameters
Description - avoid default constructor and create a private constructor that sets the field values
Level - Warning
```

In the recipe below I match on a default constructor:


```
search:
  constructor:
    without:
      child:
        argument: {}
```

And then perform two actions:

- rewrite the constructor to be private, and force instantiation of the fields
- add a static factory method which returns a new object

```
availableFixes:
- name: "amend to private constructor that sets fields with a static factory create\
    \ method"
  actions:
  - rewrite:
      to: "private {{{ name }}}({{#sed}}{{#encodeString}}s/(.*),/$1/{{/encodeString}},{{#encodeString}}\n\
        {{#containingClass.fields}}final {{typeElement}} {{name}}, {{/containingClass.fields}}{{/encodeString}}{{/sed}}){\n\
        {{#containingClass.fields}}this.{{name}}={{name}};\n        {{/containingClass.fields}}\n\
        }"
      target: "self"
  - addMethod:
      method: "public static final {{{ name }}} create({{#sed}}{{#encodeString}}s/(.*),/$1/{{/encodeString}},{{#encodeString}}\n\
        {{#containingClass.fields}}final {{typeElement}} {{name}}, {{/containingClass.fields}}{{/encodeString}}{{/sed}}){\n\
        return new {{{ name }}}({{#sed}}{{#encodeString}}s/(.*),/$1/{{/encodeString}},{{#encodeString}}{{#containingClass.fields}}{{name}},\
        \ {{/containingClass.fields}}{{/encodeString}}{{/sed}});\n}"
      position:
        after:
          constructor: {}
      target: "parentClass"
```


The above recipe looks pretty complicated because of all the embedded `sed` functionality.

Also I used the Mustache `foreach` construct to iterate over all the fields. When writing a `foreach` in the template it is important to use `{{` rather than `{{{` and to have no spaces when matching on the `#` i.e. `{{#containingClass.fields}}` not `{{{ #containingClass.fields }}}`- why might the 2nd representation crop up? Because when we add variables from the `Show Variables` list, in order to have the text unescaped (i.e. normal) we add it to the template as `{{{`.


### Making Fields `final`

**Before:**

```
private int x;
```

**After:**

```
private final int x;
```


#### Making Fields `final` with a Sensei Recipe

This recipe is a good candidate to use with the "Fix All" Context Menu Action.

```
Name: Immutable: Fields should be final and set in the constructor
Description: Making fields final can highlight mutability issues
Level: Warning
```

```
search:
  field:
    without:
      modifier: final
```

```
availableFixes:
- name: "make fields `final`"
  actions:
  - rewrite:
      to: "{{{ modifierList }}} final {{{ typeElement }}} {{{ name }}};"
      target: "self"
```

### More Steps

If I applied all of the above recipes on my class I would still have some steps to implement because my code would no longer be syntactically correct.

Because my fields are final, my setter methods would no longer pass a syntax check:

```
    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
```

And my `transform` method would fail for the same reason:

```
    public void transform(int xAdjust, int yAdjust){
        this.x+=xAdjust;
        this.y+=yAdjust;
    }
```

Ideally I would want to remove the void methods and return a newly constructed Immutable object.

### Remove void setter methods

I can automatically remove any `public` `void` setter methods, and rely on the static factory method or constructor.

**Before:**

```
    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
```

**After:**

```

```

_NOTE: the methods were completely removed._

This is another QuickFix that is a good candidate for tryin the "Fix All" functionality.


#### Sensei Recipe to Remove void setter methods

In  my recipe I match any method with a name beginning with `set` which has been declared as `public` with a return type of `void`. And then have a rewrite action to delete the code.

```
Name - delete public void setters
Description - void setters can be replaced with use of constructor or static factory methods
Level - Warning
```

```
search:
  method:
    with:
      modifier: "public"
      returnType: "void"
    name:
      matches: "set.*"
```      

```
availableFixes:
- name: "Delete The public void method"
  actions:
  - rewrite:
      to: ""
      target: "self"
```

### Warn about non-void setter methods

If I had a non-void setter method then I probably don't want to automatically transform this code, as I would need to manually amend my code to avoid the need to return a value from a setter in the first place.

I could create a recipe to alert me to this condition.

```
Name - Immutable: avoid setters that return values
Description - avoid setters methods that return values
Level - Error
```

```
search:
  method:
    with:
      modifier: "public"
      returnType:
        not: "void"
    name:
      matches: "set.*"
```

```
availableFixes:
- name: "Fix the code by manual refactoring"
  actions: []
```      

### Avoid void methods

Void methods mean that a side-effect has probably taken place and really I want to return a new Immutable object.

That can be a complicated refactor because we may need to perform complex setup, so this refactoring is partial in that it just removes the `void`, triggering a syntax error to remind me that I need to return an immutable object.

**Before:**

```
    public void transform(int xAdjust, int yAdjust){
        this.x+=xAdjust;
        this.y+=yAdjust;
    }
```

**After:**

```
    public Object transform(int xAdjust, int yAdjust){
        this.x+=xAdjust;
        this.y+=yAdjust;
    }
```

Then I would manually amend it to fix the syntax error e.g.

```
    public Coordinates transform(int xAdjust, int yAdjust){
        return new Coordinates(this.x + xAdjust, this.y + yAdjust);
    }
```


#### Avoid void methods with a Sensei Recipe

```
Name - Immutable: avoid void methods
Description - void methods have side-effects, return a new oject or primitve instead
Level - Warning
```

```
search:
  method:
    not:
      modifier: private
    in:
      class:
        name:
          not:
            matches: .*Test
    returnType: void
```

I added the extra check to not match in Test classes because I do often have `void` methods in Test classes for support and setup code.


```
availableFixes:
- name: "Make this return an Object"
  actions:
  - changeType:
      type: "Object"
```

### Use Getters

Tempting as it may be to create fields which are `public final` and avoid writing getters.

Having an abstraction in place to create a longer term interface and hide the internal implementation seems like a sensible option.

So I wrote a recipe to convert my `public` fields without getters to private fields with `getX` methods.

**Before:**

```
public int x;
```

**After:**

```
private int x;

public final int getX(){
        return x;
}
```

#### Use Getters With a Sensei Recipe

```
Name - Immutability: use a getter rather than public field
Description - To encourage use of interfaces rather than direct field access, add a getter.
Level - Warning
```

This search looks for a field which is public and not in a `typeDeclaration` which contains a child method named _getX_ (where _X_ is the name of the field).

```
search:
  field:
    not:
      in:
        typeDeclaration:
          with:
            child:
              method:
                name:
                  caseSensitive: false
                  is: get{{{markedElement.name}}}
    modifier: public
```

Note: the `markedElement` gives me access to the publi field as a template.

```
availableFixes:
- name: "add a getter and make private"
  actions:
  - addMethod:
      method: "public final {{{markedElement.typeElement}}} get{{#upperCaseFirst}}{{{markedElement.name}}}{{/upperCaseFirst}}(){\n\
        \   return {{{markedElement.name}}};\n}"
      target: "parentClass"
  - changeModifiers:
      visibility: "private"
```

The QuickFix adds a 'get' method which is `public final` and returns the 'type', then changes the field visibility to `private`.

### Summary

Some of the basic concepts of immutability are fairly simple:

- prevent extension of the class by making it `final`
- avoid setter methods and rely on fully constructed objects either from a constructor, or a static factory method
- avoid public `void` methods to reduce external side-effects
- make fields `final` to prevent internal side-effects

But the correct combination of transformations to choose varies depending on the context of the class and how far we want to take immutability.

To support the adoption of immutability, creating a contextual set of Sensei recipes can help flag the problem, and offer choice to the programmer about which set of transformations to apply.

Use the `AbuseOpenCoordinates` class in the `test` folder in `immutability.exercise`. The tests in `AbuseOpenCoordinatesTest` should start failing as you migrate the class to become more immutable.