# Do not leak internal state - Collections


- returning an instance's private field of type Collection allows external manipulation of the internal state because the collections are mutable. This can lead to unexpected program behavior when external classes manipulate data in the collection, especially in multi-threaded situations.</li>

## Before (List Example)

```
public class ListExample {
    private List<String> myList;

    public List<String> getMyList() {
        return myList;
    }
}
```

## After applying Quickfix - Return an unmodifiable copy of the Collection

```
public class ListExample {
    private List<String> myList;

    public List<String> getMyList() {
        return (List<String>)java.util.Collections.unmodifiableCollection(myList);
    }
}
```

## After applying Quickfix - return an unmodifiable List

```
public class ListExample {
    private List<String> myList;

    public List<String> getMyList() {
        return java.util.Collections.unmodifiableList(myList);
    }
}
```

## Before (Set Example)

```
public class SetExample {
    private Set<String> mySet;

    public Set<String> getSet() {
        return mySet;
    }
}
```

## After applying Quickfix - return an unmodifiable Set

```
public class SetExample {
    private Set<String> mySet;

    public Set<String> getSet() {
        return java.util.Collections.unmodifiableSet(mySet);
    }
}
```
