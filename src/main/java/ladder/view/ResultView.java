package ladder.view;

import ladder.domain.*;

import java.io.PrintStream;
import java.util.List;

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
        printNewLine();
    }

    public static void printLadderGame(LadderGame ladderGame) {

        ResultView.printParticipants(ladderGame.getGameInfo().getParticipants());
        ResultView.printLines(ladderGame.getLines());
        ResultView.printGoals(ladderGame.getGameInfo().getGoals());
    }

    private static void printParticipants(Participants participants) {

        participants.getParticipantsName()
                .forEach(ResultView::printName);
        printNewLine();
    }

    private static void printName(String name) {

        printStream.print(String.format(PRINT_PARTICIPANTS_FORMAT, name));
    }

    private static void printLines(Lines lines) {

        lines.getLines()
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

    private static void printGoals(Goals goals) {

        goals.getGoals()
                .stream().map(Goal::getResult)
                .forEach(result -> printStream.print(String.format(PRINT_PARTICIPANTS_FORMAT, result)));
        printNewLine();
    }

    public static void printParticipantGoals(List<ParticipantGoal> participantGoals) {

        printResultMessage();
        participantGoals.forEach(ResultView::printParticipantGoal);
        printNewLine();
    }

    private static void printParticipantGoal(ParticipantGoal participantGoal) {
        printStream.println(String.format(PARTICIPANT_GOAL_FORMAT, participantGoal.getParticipant().getName(), participantGoal.getGoal().getResult()));
    }

    public static void printNewLine() {

        printStream.println();
    }
}
