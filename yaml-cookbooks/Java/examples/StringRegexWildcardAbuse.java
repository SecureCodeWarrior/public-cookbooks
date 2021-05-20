public class StringRegexWildcardAbuse
{
    public void stringFirstArgumentUsesRegex() {
        String[] s =  "Hello.World".split(".");
        String s1 = "Hello.World".replaceAll(".", " ");
        String s2 = "Hello.World".replaceFirst(".", " ");
    }
}