package ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LadderLine {
    private final List<Boolean> establishedResults;

    private LadderLine(List<Boolean> establishedResults) {
        this.establishedResults = establishedResults;
    }

    private static List<Boolean> doLadderEstablish(int countOfColumn) {
        List<Boolean> results = new ArrayList<>(countOfColumn);
        Random random = new Random();

        for (int index = 0; index < countOfColumn; index++) {
            boolean isCanEstablish = random.nextBoolean();
            boolean isDoEstablish = isPreviousNotEstablished(results, index) && isCanEstablish;
            results.add(isDoEstablish);
        }

        return results;
    }

    private static boolean isPreviousNotEstablished(List<Boolean> establishedResult, int currentIndex) {
        if (currentIndex == 0) {
            return true;
        }

        return !establishedResult.get(currentIndex - 1);
    }

    public static LadderLine of(int countOfColumn) {
        List<Boolean> establishedResults = doLadderEstablish(countOfColumn);
        return new LadderLine(establishedResults);
    }

    public List<Boolean> getEstablishResults() {
        return Collections.unmodifiableList(this.establishedResults);
    }
}
