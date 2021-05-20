import java.util.List;
import java.util.Set;

class DoNotExposeInternalCollection {
    private List<String> l;
    private Set<String> s;
    private Integer i;

    public List<String> getL() {
        return l; // should mark
    }

    public Set<String> getS()
    {
        return s; // should mark
    }

    public Integer getI() {
        return i; // should not mark
    }
}
