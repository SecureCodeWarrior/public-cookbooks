class A {
    public static final int a = B.b + 1;
    // ...
}

class B {
    public static final int b = A.a + 1;
    // ...
}