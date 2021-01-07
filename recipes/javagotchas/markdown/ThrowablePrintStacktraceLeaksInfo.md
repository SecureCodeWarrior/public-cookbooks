# Throwable.printStacktrace leaks valuable program structure information

- Name: Throwable.printStacktrace leaks valuable program structure information
- Short Description: Info Leakage - printing a stacktrace gives valuable information about software internals, including library/framework names and versions, to an attacker.

Calling the method printStaceTrace() on subclasses of java.lang.Throwable will result in valuable program information being printed on standard err for the program.

Calling either of the methods printStaceTrace(PrintStream)  or printStaceTrace(PrintWriter) on subclasses of java.lang.Throwable may result in valuable program information being written to unexpected destinations. 

In general, it is a best practice to use a logging utility to control the output format and level of detail stored about exceptions and manage the destination of the information. In the absence of such a library, only printing the exception message is preferred.

## Recipe Details

```
search:
  methodcall:
    name: "printStacktrace"
    type: "java.lang.Throwable"
```

```
availableFixes:
- name: "Throwable.printStacktrace - just print the message instead"
  actions:
    rewrite:
      to: "System.err.println({{{ qualifier }}}.getMessage())"
          
```

## Before
```
    public void doSomething() {
        try{
            bar();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
```

## After applying Quickfix - Escape the regex special character for any char

```
    public void doSomething() {
        try{
            bar();
        }catch(Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }
```    
