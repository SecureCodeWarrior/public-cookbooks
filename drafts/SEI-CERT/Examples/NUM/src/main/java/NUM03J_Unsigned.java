import java.io.DataInputStream;
import java.io.IOException;

public class NUM03J_Unsigned {

    public static int getIntegerBad(DataInputStream is) throws IOException {
        return is.readInt(); // Assumes data is signed and uses first bit as sign
    }

    public static long getIntegerGood(DataInputStream is) throws IOException {
        return is.readInt() & 0xFFFFFFFFL; // Mask with 32 one-bits (converts to long with sign extension)
    }

}
