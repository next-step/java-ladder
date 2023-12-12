package engine.view;

import ladder.LadderResult;
import ladder.LadderResultSet;

public class LadderResultSetRenderer {
    private LadderResultSetRenderer() {
    }

    public static void printSingleResult(LadderResult ladderResult) {
        MessageRenderer.simplePrint(ladderResult.name().toPrintableString(), false);
        MessageRenderer.simplePrint(" : ", false);
        MessageRenderer.simplePrint(ladderResult.resultItem().toPrintableString(), true);
    }

    public static void printSet(LadderResultSet resultSet) {
        for (LadderResult ladderResult : resultSet.toIterable()) {
            printSingleResult(ladderResult);
        }
    }
}
