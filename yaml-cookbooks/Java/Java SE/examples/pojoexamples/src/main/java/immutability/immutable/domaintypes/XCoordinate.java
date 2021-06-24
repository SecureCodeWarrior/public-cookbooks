package immutability.immutable.domaintypes;

public final class XCoordinate {

    private final Integer value;

    private XCoordinate(Integer value) {
        this.value = value;
    }

    public static XCoordinate xCoordinate(Integer value) {
        return new XCoordinate(value);
    }

    public Integer getValue() {
        return value;
    }
}
