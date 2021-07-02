class A3 {
    public static int a = B3.b();
    public static int c() { return 1; }
}

class B3 {
    public static int b() { return A3.c(); }
}