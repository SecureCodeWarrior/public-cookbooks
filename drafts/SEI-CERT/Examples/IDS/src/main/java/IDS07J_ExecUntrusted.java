import java.io.File;
import java.io.InputStream;
import java.util.regex.Pattern;

public class IDS07J_ExecUntrusted {
    public static void badWindows(String[] args) throws Exception {
        String dir = System.getProperty("dir");
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec("cmd.exe /C dir " + dir);
        int result = proc.waitFor();
        if (result != 0) {
            System.out.println("process error: " + result);
        }
        InputStream in = (result == 0) ? proc.getInputStream() :
                proc.getErrorStream();
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
    }

    public static void badPOSIX(String[] args) throws Exception {
        String dir = System.getProperty("dir");
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec(new String[] {"sh", "-c", "ls " + dir});
        int result = proc.waitFor();
        if (result != 0) {
            System.out.println("process error: " + result);
        }
        InputStream in = (result == 0) ? proc.getInputStream() :
                proc.getErrorStream();
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
    }

    public static void goodValidation(String[] args) throws Exception {
        String dir = System.getProperty("dir");

        if (!Pattern.matches("[0-9A-Za-z@.]+", dir)) {
            // Handle error
        }

        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec(new String[] {"sh", "-c", "ls " + dir});
        int result = proc.waitFor();
        if (result != 0) {
            System.out.println("process error: " + result);
        }
        InputStream in = (result == 0) ? proc.getInputStream() :
                proc.getErrorStream();
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
    }

    public static void goodOptions(String[] args) throws Exception {
        String dir = null;

        int number = Integer.parseInt(System.getProperty("dir")); // Only allow integer choices
        switch (number) {
            case 1:
                dir = "data1";
                break; // Option 1
            case 2:
                dir = "data2";
                break; // Option 2
            default: // Invalid
                break;
        }
        if (dir == null) {
            // Handle error
        }

        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec(new String[] {"sh", "-c", "ls " + dir});
        int result = proc.waitFor();
        if (result != 0) {
            System.out.println("process error: " + result);
        }
        InputStream in = (result == 0) ? proc.getInputStream() :
                proc.getErrorStream();
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
    }

    public static void goodNoExec(String[] args) throws Exception {
        File dir = new File(System.getProperty("dir"));
        if (!dir.isDirectory()) {
            System.out.println("Not a directory");
        } else {
            for (String file : dir.list()) {
                System.out.println(file);
            }
        }
    }
}
