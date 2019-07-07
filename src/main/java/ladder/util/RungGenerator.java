package ladder.util;

import java.util.ArrayList;
import java.util.List;

public class RungGenerator {

    public Boolean generate() {
        return true;
    }

    public Boolean generate(boolean isRung) {
        return isRung;
    }

    public List<Boolean> generate(int countOfPlayers) {
        List<Boolean> rungs = new ArrayList<>();

        for(int i = 0; i < countOfPlayers; i++) {
            boolean previousValue = getPreviousValue(rungs);
            rungs.add(generate(oppositeRule(previousValue)));
        }
        return rungs;
    }

    public boolean getPreviousValue(List<Boolean> rungs) {
        if (rungs.isEmpty()) {
            return false;
        }
        return rungs.get(rungs.size() - 1);
    }

    public boolean oppositeRule(boolean previousValue) {
        return !previousValue;
    }


}
