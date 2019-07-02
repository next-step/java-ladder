package ladder.util;

import ladder.model.Rung;

import java.util.ArrayList;
import java.util.List;

public class RungGenerator {

    public static Rung generate() {
        return new Rung(true);
    }

    public static Rung generate(boolean isRung) {
        return new Rung(isRung);
    }

    public static List<Rung> generate(int countOfPlayers) {
        List<Rung> rungs = new ArrayList<>();

        for(int i = 0; i < countOfPlayers; i++) {
            boolean previousValue = getPreviousValue(rungs);
            rungs.add(generate(oppositeRule(previousValue)));
        }
        return rungs;
    }

    public static boolean getPreviousValue(List<Rung> rungs) {
        if (rungs.isEmpty()) {
            return false;
        }
        return rungs.get(rungs.size() - 1).isRung();
    }

    public static boolean oppositeRule(boolean previousValue) {
        return !previousValue;
    }


}
