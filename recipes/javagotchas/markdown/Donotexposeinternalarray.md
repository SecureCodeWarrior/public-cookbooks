# Do not expose internal array

Exposed internal arrays are still mutable. This violates the object encapsulation rule for the internal property.

**before:**

```java
class Dto {
	protected String[] values;

	public String[] getValues()
	{
		return values;
	}
}
```

**after:**

```java
class Dto {
	protected String[] values;

	public String[] getValues()
	{
		return Arrays.copyOf(values, values.length);
	}
}
```