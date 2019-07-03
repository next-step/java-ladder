package ladder.util;

import ladder.model.Rung;

import java.util.ArrayList;
import java.util.List;

public class RungGenerator {

    public Rung generate() {
        return new Rung(true);
    }

    public Rung generate(boolean isRung) {
        return new Rung(isRung);
    }

    public List<Rung> generate(int countOfPlayers) {
        List<Rung> rungs = new ArrayList<>();

        for(int i = 0; i < countOfPlayers; i++) {
            boolean previousValue = getPreviousValue(rungs);
            rungs.add(generate(oppositeRule(previousValue)));
        }
        return rungs;
    }

    public boolean getPreviousValue(List<Rung> rungs) {
        if (rungs.isEmpty()) {
            return false;
        }
        return rungs.get(rungs.size() - 1).isRung();
    }

    public boolean oppositeRule(boolean previousValue) {
        return !previousValue;
    }


}
