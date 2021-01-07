# Use a logical AND operator instad of a bitwise AND operator

**before:**

```java
if (true & false) {
	Assert.assertTrue("We should have used a proper conditional", true);
}
```

**after:**

```java
if (true && false) {
	Assert.assertTrue("We should have used a proper conditional", true);
}
```