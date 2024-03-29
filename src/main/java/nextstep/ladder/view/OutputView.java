package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Names;

public class OutputView {

    private static final int BRIDGE_LENGTH = 4;

    public void printLadder(final Names names, final Ladder ladder) {
        System.out.println("\n실행 결과");

        System.out.println();
        names.getNames().forEach(name -> System.out.print(name.getName() + " "));
        System.out.println();

        ladder.getLines().forEach(this::printLine);
    }

    private void printLine(final Line line) {
        System.out.print(" ");
        for (final Boolean point : line.getPoints()) {
            System.out.print("|");
            printBridge(point);
        }
        System.out.print("|\n");
    }

    private void printBridge(final Boolean point) {
        if (point) {
            System.out.print("-".repeat(BRIDGE_LENGTH));
            return;
        }
        System.out.print(" ".repeat(BRIDGE_LENGTH));
    }
}
