package nextstep.ladder.view;

import nextstep.ladder.domain.Bridge;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Names;
import nextstep.ladder.domain.LadderResultManager;

public class OutputView {

    private static final int BRIDGE_LENGTH = 4;
    private static final String NAME_RESULT_DELIMITER = " : ";
    private static final String ALL_NAMES = "all";

    public void printLadder(final Names names, final Ladder ladder) {
        System.out.println("\n실행 결과");

        System.out.println();
        names.getNames().forEach(name -> System.out.print(name.getName() + " "));
        System.out.println();

        ladder.getLines().forEach(this::printLine);
    }

    private void printLine(final Line line) {
        System.out.print(" ");
        for (final Bridge bridge : line.getBridges()) {
            System.out.print("|");
            printBridge(bridge);
        }
        System.out.print("|\n");
    }

    public void printResult(final String name, final LadderResultManager ladderResultManager) {
        if (ALL_NAMES.equals(name)) {
            ladderResultManager.getResults().forEach((n, r) -> System.out.println(n.getName() + NAME_RESULT_DELIMITER + r));
            return;
        }
        System.out.println(name + NAME_RESULT_DELIMITER + ladderResultManager.getResultByName(new Name(name)));
    }

    private void printBridge(final Bridge bridge) {
        if (bridge.isBridge()) {
            System.out.print("-".repeat(BRIDGE_LENGTH));
            return;
        }
        System.out.print(" ".repeat(BRIDGE_LENGTH));
    }
}
