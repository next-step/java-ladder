package step2.view;

import step2.model.Ladder;
import step2.model.Line;
import step2.model.Person;

import java.util.List;

public class OutputView {

    private static final String INITIAL_LINE = "    |";
    private static final String RUNG_CONDITION_TRUE = "-----|";
    private static final String RUNG_CONDITION_FALSE = "     |";

    public static void printAll(List<Person> participants, Ladder ladderGame) {
        Banner();
        printNameList(participants);
        printLadder(ladderGame);
    }

    public static void Banner() {
        System.out.println("실행결과");
        System.out.println();
    }

    public static void printNameList(List<Person> participants) {
        StringBuffer nameLine = new StringBuffer();
        for (Person person : participants) {
            nameLine.append(person.printName());
            nameLine.append(" ");
        }
        System.out.println(nameLine.toString());
    }

    public static void printLadder(Ladder ladder) {
        int height = ladder.getHeightOfLadder();
        for (int loop = 0; loop < height; loop++) {
            printLine(ladder.getLineOfHeight(loop));
        }
    }

    private static void printLine(Line line) {
        StringBuffer lineView = new StringBuffer();
        lineView.append(INITIAL_LINE);
        for (boolean rung : line.getRungs()) {
            drawRung(lineView, rung);
        }
        System.out.println(lineView);
    }

    private static void drawRung(StringBuffer lineView, boolean rung) {
        if (rung) {
            lineView.append(RUNG_CONDITION_TRUE);
        }
        if (!rung) {
            lineView.append(RUNG_CONDITION_FALSE);
        }
    }
}
