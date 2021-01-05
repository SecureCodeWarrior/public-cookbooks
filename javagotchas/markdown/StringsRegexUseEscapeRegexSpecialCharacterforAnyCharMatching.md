# Split uses a Regex `.` matches any Character

- Name: Strings : Regex Use : Escape Regex Special Character for Any Char Matching
- Short Description: Split uses a regex - escape the dot or you generate an empty array

The String `split` method takes a Regular Expression as a parameter. Unfortunately sometimes we use Special Characters as String delimiters e.g. `"."`

When trying to `split` by `"."` we will not get the result we expect. Instead every character in the String will be used as a split point, resulting in an empty array. We need to use `"\\.|"` instead i.e. the `.` escaped in a `String`.


## Recipe Details

```
search:
  methodcall:
    args:
      1:
        value: "."
    name: "split"
    type: "java.lang.String"
```

```
availableFixes:
- name: "Escape the regex special character for any char"
  actions:
  - modifyArguments:
      rewrite:
        1: "\"\\\\.\""
```

## Before

    @Test
    void splitOnEverything(){

        String[] parts;

        parts = "123.456.789.012".split(".");

        Assertions.assertEquals(0, parts.length);
        // we actually wanted 4 so should have used "\\."
    }

## After applying Quickfix - Escape the regex special character for any char

```
    @Test
    void splitOnEverything(){

        String[] parts;

        parts = "123.456.789.012".split("\\.");

        Assertions.assertEquals(0, parts.length);
        // we actually wanted 4 so should have used "\\."
    }
```    

Note: the above test would fail after running the QuickFix because I would need to amend the assertion as well to:

```
Assertions.assertEquals(0, parts.length);
```