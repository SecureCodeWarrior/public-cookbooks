public class ThrowableNotThrown {
    public void testThrowableRecipe() {
        new Throwable();
        new NullPointerException();

        Throwable t = new Throwable();
        Throwable t2 = new NullPointerException();

        throw new NullPointerException();
    }
}
