package step2.view;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final String LADDER_VERTICAL_LINE = "|";
    private static final String LADDER_HORIZON = "-----";
    private static final String LADDER_EMPTY = "     ";
    private static final String NAME_SPACE = "   ";
    private static final String GUIDE_HEAD_LINE = "실행 결과";

    public void printHeader() {
        System.out.println(GUIDE_HEAD_LINE);
    }

    public void printLadderResult(List<Boolean> points, int countOfPerson) {
        for (Boolean point: points) {
            printLadderLine(point, countOfPerson);

        }
        System.out.print(LADDER_VERTICAL_LINE);
    }

    public void printLadderLine(Boolean point, int countOfPerson) {
        System.out.print(LADDER_VERTICAL_LINE);
        if (point) {
            System.out.print(LADDER_HORIZON);
            return;
        }
        System.out.print(LADDER_EMPTY);
        return;
    }

    public void printParticipant(String[] array) {
        for (String name: array) {
            System.out.print(name+NAME_SPACE);
        }
        System.out.println();
    }
}
