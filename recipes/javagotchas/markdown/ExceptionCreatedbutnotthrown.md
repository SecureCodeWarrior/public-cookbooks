# Exceptions should be thrown, not just created

**before:**

```java
try {
	String bob = null;
	bob.trim();
} catch (NullPointerException e) {
	new RuntimeException("Found nullpointer", e);
}
```

**after:**

```java
try {
	String bob = null;
	bob.trim();
} catch (NullPointerException e) {
	throw new RuntimeException("Found nullpointer", e);
}
```