package ladder.util;

import java.util.List;

public interface RungGenerator {

    default Boolean generate() {
        return true;
    }

    default Boolean generate(boolean isRung) {
        return isRung;
    }

    default boolean getPreviousValue(List<Boolean> rungs) {
        if (rungs.isEmpty()) {
            return false;
        }
        return rungs.get(rungs.size() - 1);
    }

    List<Boolean> generate(int countOfPlayers);
}
