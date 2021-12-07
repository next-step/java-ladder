package ladder.domain;

public class Rung implements LadderPart {

    private static final String RUNG_VALUE = "-----";
    private static final String EMPTY_RUNG_VALUE = "     ";

    private static final Rung rung = new Rung(RUNG_VALUE);
    private static final Rung emptyRung = new Rung(EMPTY_RUNG_VALUE);

    private final String value;

    private Rung(String value) {
        this.value = value;
    }

    public static Rung rung(boolean isSet) {
        if (isSet) {
            return rung;
        }
        return emptyRung;
    }

    @Override
    public String value() {
        return value;
    }

}
