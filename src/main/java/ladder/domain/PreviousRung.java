package ladder.domain;

import java.util.Optional;

public class PreviousRung {

    private static final PreviousRung setRung = new PreviousRung(true);
    private static final PreviousRung nonSetRung = new PreviousRung(false);

    private final boolean set;

    private PreviousRung(boolean set) {
        this.set = set;
    }

    public static PreviousRung of(boolean set) {
        if (set) {
            return setRung;
        }
        return nonSetRung;
    }

    public boolean isSet() {
        return set;
    }

    public PreviousRung changedRung(LadderPart ladderPart) {
        if (ladderPart == null || ladderPart.isInstanceOf(Rail.class)) {
            return this;
        }

        return Optional.of((Rung) ladderPart)
                .map(Rung::on)
                .map(PreviousRung::of)
                .orElse(PreviousRung.of(false));
    }

}
