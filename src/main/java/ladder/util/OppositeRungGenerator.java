package ladder.util;

import java.util.ArrayList;
import java.util.List;

public class OppositeRungGenerator implements RungGenerator {

    @Override
    public List<Boolean> generate(int countOfPlayers) {
        List<Boolean> rungs = new ArrayList<>();

        for(int i = 0; i < countOfPlayers; i++) {
            boolean previousValue = getPreviousValue(rungs);
            rungs.add(generate(oppositeRule(previousValue)));
        }
        return rungs;
    }

    public boolean oppositeRule(boolean previousValue) {
        return !previousValue;
    }


}
