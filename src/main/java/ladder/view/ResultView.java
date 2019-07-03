package ladder.view;

import ladder.domain.*;

import java.io.PrintStream;

import static ladder.view.PrintSymbol.*;

public class ResultView {

    private static final PrintStream printStream = System.out;

    private static final String RESULT_MESSAGE = "실행결과";

    private static final int SIZE = 10;
    private static final String CONNECT_STRING = buildConnectString(SIZE);
    private static final String EMPTY_STRING = buildEmptyString(SIZE);
    private static final String PRINT_PARTICIPANTS_FORMAT = "%-" + SIZE + "s";
    private static final String PARTICIPANT_GOAL_FORMAT = "%s : %s";

    public static void printResultMessage() {

        printStream.println(RESULT_MESSAGE);
    }

    public static void printParticipants(Participants participants) {

        participants.getParticipantsName()
                .forEach(ResultView::printName);
        printNewLine();
    }

    private static void printName(String name) {

        printStream.print(String.format(PRINT_PARTICIPANTS_FORMAT, name));
    }

    public static void printLadder(Ladder ladder) {

        ladder.getLines()
                .getLines()
                .forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {

        line.getPoints()
                .forEach(ResultView::printPoint);

        printNewLine();

    }

    private static void printPoint(Point point) {

        printStream.print(STEP);
        if (Direction.RIGHT == point.getDirection()) {
            printStream.print(CONNECT_STRING);
            return;
        }
        printStream.print(EMPTY_STRING);

    }

    public static void printGoals(Goals goals) {

        goals.getGoals()
                .stream().map(Goal::getResult)
                .forEach(result -> printStream.print(String.format(PRINT_PARTICIPANTS_FORMAT, result)));
        printNewLine();
    }

    public static void printPersonalResult(String name, Goal goal) {

        printResultMessage();

        printStream.println(String.format(PARTICIPANT_GOAL_FORMAT, name, goal.getResult()));
        printNewLine();
    }

    public static void printAllResult(ParticipantGoals participantGoals, Participants participants) {

        printResultMessage();
        participants.getParticipantsName()
                .forEach(name -> printStream.println(String.format(PARTICIPANT_GOAL_FORMAT, name, participantGoals.findGoal(name).getResult())));
    }

    public static void printNewLine() {

        printStream.println();
    }
}
