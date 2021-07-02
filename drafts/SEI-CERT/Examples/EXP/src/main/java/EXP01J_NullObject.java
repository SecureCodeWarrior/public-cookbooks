import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

public class EXP01J_NullObject {
    public static int cardinalityBad(Object obj, final Collection<?> col) {
        int count = 0;
        if (col == null) {
            return count;
        }
        Iterator<?> it = col.iterator();
        while (it.hasNext()) {
            Object elt = it.next();
            if ((null == obj && null == elt) || obj.equals(elt)) {  // Null pointer dereference
                count++;
            }
        }
        return count;
    }

    public static int cardinalityGood(Object obj, final Collection<?> col) {
        int count = 0;
        if (col == null) {
            return count;
        }
        Iterator<?> it = col.iterator();
        while (it.hasNext()) {
            Object elt = it.next();
            if ((null == obj && null == elt) ||
                    (null != obj && obj.equals(elt))) {
                count++;
            }
        }
        return count;
    }

    public boolean isCapitalized(String text) {
        return true;
    }

    public boolean isProperNameBad(String s) {
        String[] names = s.split(" ");
        if (names.length != 2) {
            return false;
        }
        return (isCapitalized(names[0]) && isCapitalized(names[1]));
    }

    private boolean isProperNameGood(String s) { // Shield off using private
        String[] names = s.split(" ");
        if (names.length != 2) {
            return false;
        }
        return (isCapitalized(names[0]) && isCapitalized(names[1]));
    }

    public boolean testString(String s) {
        if (s == null) return false; // Check to prevent null pointers dereference
        else return isProperNameGood(s);
    }

    public boolean isProperNameOptional(Optional<String> os) {
        String[] names = os.orElse("").split(" ");
        return names.length == 2 && (isCapitalized(names[0]) && isCapitalized(names[1]));
    }

}
