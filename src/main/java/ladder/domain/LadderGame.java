package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private InputValueStatus inputValueStatus;
    private List<Line> lineList = new ArrayList<>();
    private Names names;

    public LadderGame(final String names, final int ladderHeight) {
        initLadderGame(names, ladderHeight);
    }

    private void initLadderGame(final String names, final int ladderHeight) {
        this.inputValueStatus = new InputValueStatus(names, ladderHeight);
        this.names = new Names(names);

        addLine(ladderHeight);
    }

    private void addLine(final int ladderHeight) {
        Line line;

        for (int i = 0; i < ladderHeight; i++) {
            line = new Line(this.names.getNames().size());
            this.lineList.add(line);
        }
    }

    public void printLadder() {
        PrintLadder printLadder = new PrintLadder();
        printLadder.printNames(names.getNames());

        for (Line line : lineList) {
            printLadder.printLadder(line.getPoints(), names.getNames().size());
        }

    }
}
