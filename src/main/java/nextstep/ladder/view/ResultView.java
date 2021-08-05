package nextstep.ladder.view;

import nextstep.ladder.domain.LadderLineStrategy;
import nextstep.ladder.domain.LadderNames;
import nextstep.ladder.domain.Lines;

public class ResultView {
    public void print(LadderNames ladderNames, int maxLadderHeight) {
        printLadderName(ladderNames);
        printLadderLines(ladderNames, maxLadderHeight);
    }

    public void printLadderLines(LadderNames ladderNames, int maxLadderHeight) {
        for(int i = 0; i < maxLadderHeight; i++) {
            printLines(new Lines(ladderNames.size(), new LadderLineStrategy()));
        }
    }

    private void printLines(Lines lines) {
        System.out.println(lines.getLines().toString().replaceAll("\\[|\\]", "").replaceAll(", ", ""));
    }

    public void printLadderName(LadderNames ladderNames) {
        System.out.println(ladderNames.toString().replaceAll("\\[|\\]", "").replaceAll(",", ""));
    }
}
