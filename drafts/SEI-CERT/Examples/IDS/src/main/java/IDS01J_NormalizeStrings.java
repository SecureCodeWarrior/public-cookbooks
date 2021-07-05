import java.text.Normalizer; // https://docs.oracle.com/javase/8/docs/api/java/text/Normalizer.html
import java.text.Normalizer.Form; // https://docs.oracle.com/javase/8/docs/api/java/text/Normalizer.Form.html
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDS01J_NormalizeStrings
{
    // NOTE: Deny-listing is not recommended!
    public void bad() {
        // String s may be user controllable
        // \uFE64 is normalized to < and \uFE65 is normalized to > using the NFKC normalization form
        String s = "\uFE64" + "script" + "\uFE65";

        // Validate
        Pattern pattern = Pattern.compile("[<>]"); // Check for angle brackets
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            // Found deny-listed tag
            throw new IllegalStateException();
        } else {
            // ...
        }
    }

    public void compliant() {
        String s = "\uFE64" + "script" + "\uFE65";

        // Normalize
        s = Normalizer.normalize(s, Form.NFKC);

        // Validate
        Pattern pattern = Pattern.compile("[<>]");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            // Found deny-listed tag
            throw new IllegalStateException();
        } else {
            // ...
        }
    }

    public void test() {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        // Validate
        Pattern pattern = Pattern.compile("[<>]"); // Check for angle brackets
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            // Found deny-listed tag
            throw new IllegalStateException();
        } else {
            // ...
        }

        // Normalize
        //s = Normalizer.normalize(s, Form.NFKC);

        pattern = Pattern.compile("[<>]"); // Check for angle brackets
        matcher = pattern.matcher(s);
        if (matcher.find()) {
            // Found deny-listed tag
            throw new IllegalStateException();
        } else {
            // ...
        }

    }
}