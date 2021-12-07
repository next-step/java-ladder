package ladder.domain;

public class Rung implements LadderPart {

    private static final String RUNG_VALUE = "-----";
    private static final String EMPTY_RUNG_VALUE = "     ";

    private static final Rung rung = new Rung(RUNG_VALUE, true);
    private static final Rung emptyRung = new Rung(EMPTY_RUNG_VALUE, false);

    private final String value;
    private final boolean on;

    private Rung(String value, boolean on) {
        this.value = value;
        this.on = on;
    }

    public static Rung rung(boolean on) {
        if (on) {
            return rung;
        }
        return emptyRung;
    }

    public boolean on() {
        return on;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean isInstanceOf(Class<?> clazz) {
        return Rung.class.equals(clazz);
    }

}
