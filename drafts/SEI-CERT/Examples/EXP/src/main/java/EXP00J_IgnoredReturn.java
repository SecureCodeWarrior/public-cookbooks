import java.io.File;

public class EXP00J_IgnoredReturn {
    public void deleteFileBad(){
        File someFile = new File("someFileName.txt");
        // Do something with someFile
        someFile.delete();
    }

    public void deleteFileGood(){
        File someFile = new File("someFileName.txt");
        // Do something with someFile
        if (!someFile.delete()) {
            // Handle failure to delete the file
        }
    }

    public static void bad(String[] args) {
        String original = "insecure";
        original.replace('i', '9');
        System.out.println(original);
    }

    public static void good(String[] args) {
        String original = "insecure";
        original = original.replace('i', '9');
        System.out.println(original);
    }
}
