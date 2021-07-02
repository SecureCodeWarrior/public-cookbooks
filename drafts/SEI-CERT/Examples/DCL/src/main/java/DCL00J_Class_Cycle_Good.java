class A4 {
    public static int a = B4.b();
}

class B4 {
    public static int b() { return B4.c(); }
    public static int c() { return 1; }
}