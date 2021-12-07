package ladder.domain;

public class Rail implements LadderPart {

    private static final String RAIL_VALUE = "|";
    private static final Rail rail = new Rail(RAIL_VALUE);

    private final String value;

    private Rail(String value) {
        this.value = value;
    }

    public static Rail rail() {
        return rail;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean isInstanceOf(Class<?> clazz) {
        return Rail.class.equals(clazz);
    }

}
