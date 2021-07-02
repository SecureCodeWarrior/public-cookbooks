import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDS11J_UntrustedDataManipulation {
    public static String filterStringBad(String str) {
        String s = Normalizer.normalize(str, Form.NFKC);

        // Validate input
        Pattern pattern = Pattern.compile("<script>");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            throw new IllegalArgumentException("Invalid input");
        }

        // Deletes non-character code points
        s = s.replaceAll("[\\p{Cn}]", "");
        return s;
    }

    public static String filterStringGood(String str) {
        String s = Normalizer.normalize(str, Form.NFKC);

        // Replaces all non-character code points with Unicode U+FFFD
        s = s.replaceAll("[\\p{Cn}]", "\uFFFD");

        // Validate input
        Pattern pattern = Pattern.compile("<script>");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            throw new IllegalArgumentException("Invalid input");
        }
        return s;
    }

    public static void main(String[] args) {
        // "\uFDEF" is a non-character code point
        String maliciousInput = "<scr" + "\uFDEF" + "ipt>";
        String sb = filterStringBad(maliciousInput);
        String sb2 = filterStringGood(maliciousInput);
        // sb = "<script>"
    }
}
