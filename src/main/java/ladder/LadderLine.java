package ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LadderLine {
    private static final int FIRST_POSITION = 0;
    private static final int VALUE_OF_ONE_POSITION = 1;

    private final List<LineState> establishedResults;

    private LadderLine(List<LineState> establishedResults) {
        this.establishedResults = establishedResults;
    }

    public static LadderLine of(int countOfPerson) {
        List<LineState> establishedResults = doLadderEstablish(countOfPerson);
        return new LadderLine(establishedResults);
    }

    public List<LineState> getEstablishResults() {
        return Collections.unmodifiableList(this.establishedResults);
    }

    public int computeNextPosition(int beginPosition) {
        if (isCanLeftGo(beginPosition)) {
            return beginPosition - VALUE_OF_ONE_POSITION;
        } else if (isCanRightGo(beginPosition)) {
            return beginPosition + VALUE_OF_ONE_POSITION;
        } else {
            return beginPosition;
        }
    }

    private boolean isCanLeftGo(int beginPosition) {
        if (beginPosition == FIRST_POSITION) {
            return false;
        }
        return establishedResults.get(beginPosition - VALUE_OF_ONE_POSITION) == LineState.ESTABLISH;
    }

    private boolean isCanRightGo(int beginPosition) {
        if (beginPosition == this.establishedResults.size()) {
            return false;
        }
        return establishedResults.get(beginPosition) == LineState.ESTABLISH;
    }

    private static List<LineState> doLadderEstablish(int countOfPerson) {
        int countOfColumn = countOfPerson - 1;
        List<LineState> results = new ArrayList<>(countOfColumn);
        Random random = new Random();

        for (int index = 0; index < countOfColumn; index++) {
            boolean isCanEstablish = random.nextBoolean();
            boolean isDoEstablish = isPreviousNotEstablished(results, index) && isCanEstablish;
            results.add(isDoEstablish ? LineState.ESTABLISH : LineState.NONE);
        }

        return results;
    }

    private static boolean isPreviousNotEstablished(List<LineState> establishedResult, int currentIndex) {
        if (currentIndex == 0) {
            return true;
        }

        return establishedResult.get(currentIndex - VALUE_OF_ONE_POSITION) == LineState.NONE;
    }

    public enum LineState {
        ESTABLISH,
        NONE
    }
}
