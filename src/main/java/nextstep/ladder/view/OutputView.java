package nextstep.ladder.view;

import nextstep.ladder.domain.Bridge;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResultDeterminer;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Names;

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

    public void printResult(final String name, final LadderResultDeterminer determiner) {
        if (ALL_NAMES.equals(name)) {
            determiner.getNames()
                    .forEach(n -> System.out.println(n.getName() + NAME_RESULT_DELIMITER + determiner.determineResult(n)));
            return;
        }
        System.out.println(name + NAME_RESULT_DELIMITER + determiner.determineResult(new Name(name)));
    }

    private void printBridge(final Bridge bridge) {
        if (bridge.isBridge()) {
            System.out.print("-".repeat(BRIDGE_LENGTH));
            return;
        }
        System.out.print(" ".repeat(BRIDGE_LENGTH));
    }
}
