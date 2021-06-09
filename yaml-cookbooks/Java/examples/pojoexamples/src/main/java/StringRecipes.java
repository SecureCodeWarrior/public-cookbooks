import java.util.Locale;

public class StringRecipes {

    public void splitString() {
        String[] parts = "127.0.0.1".split(".");
        String[] parts2 = "127.0.0.1".split("..");
        String[] parts3 = "127.0.0.1".split("0");
    }

    public void stringFirstArgumentUsesRegex() {
        String[] s =  "Hello.World".split(".");
        String s1 = "Hello.World".replaceAll(".", " ");
        String s2 = "Hello.World".replaceFirst(".", " ");
    }

    public void compareString(String a, String b) {
        boolean isMatch = a.toLowerCase().equals(b);
        boolean isMatch2 = a.toUpperCase(Locale.ROOT).equals(b);
        boolean isMatch3 = a.toLowerCase(Locale.ENGLISH).equals(b);
    }

    public void indexOfString() {
        int index = "some string".indexOf("r");
        int index2 = "some string".indexOf("s", 2);
        int index3 = "some string".indexOf("str");
        int index4 = "some string".indexOf("str", 2);
        int index5 = "some string".indexOf("\t");
    }
}
