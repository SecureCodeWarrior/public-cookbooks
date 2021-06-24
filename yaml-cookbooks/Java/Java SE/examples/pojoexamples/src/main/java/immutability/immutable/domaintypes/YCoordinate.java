package immutability.immutable.domaintypes;

public final class YCoordinate {

    private final Integer value;

    private YCoordinate(Integer value) {
        this.value = value;
    }

    public static YCoordinate yCoordinate(Integer value) {
        return new YCoordinate(value);
    }

    public Integer getValue() {
        return value;
    }
}
