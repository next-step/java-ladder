package ladder.enums;

public enum LadderPart {

    RAIL, RUNG, EMPTY_RUNG;

    public static LadderPart from(boolean shouldMakeRung) {
        if (shouldMakeRung) {
            return RUNG;
        }
        return EMPTY_RUNG;
    }

    public boolean isRail() {
        return this == RAIL;
    }

    public boolean isRung() {
        return this == RUNG;
    }

}
