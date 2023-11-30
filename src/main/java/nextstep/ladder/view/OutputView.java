package nextstep.ladder.view;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.lines.Lines;

public class OutputView {

    public static final String EXECUTION_RESULT_MESSAGE = "실행결과\n";

    public void printLadderExecutionResult(List<String> participantsName, Ladder ladder) {
        printExecutionMessage();
        printParticipants(participantsName, ladder);
        int maxHeight = ladder.getLines().getLines().get(0).getMaxHeight();
        for (int presentHeight = 0; presentHeight < maxHeight; presentHeight++) {
            printLadderOfPresentHeight(participantsName, ladder, presentHeight);
        }
    }

    private void printLadderOfPresentHeight(List<String> participantsName, Ladder ladder, int presentHeight) {
        System.out.print(" ".repeat(participantsName.get(0).length()));
        for (int j = 0; j < participantsName.size() - 1; j++) {
            System.out.print("ㅣ");
            Lines lines = ladder.getLines();
            List<Line> lines1 = lines.getLines();
            if (lines1.get(j).hasHorizontalLine(presentHeight)) {
                System.out.print("-".repeat(ladder.getWidth()));
            } else {
                System.out.print(" ".repeat(ladder.getWidth()));
            }
        }
        System.out.println("ㅣ");
    }

    private void printExecutionMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    private void printParticipants(List<String> participantsName, Ladder ladder) {
        for (String name : participantsName) {
            System.out.print(name + " ".repeat(ladder.getWidth() + 2 - name.length()));
        }
        System.out.println();
    }
}
