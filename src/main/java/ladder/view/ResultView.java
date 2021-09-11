package ladder.view;

import ladder.domain.game.GameResult;
import ladder.domain.ladder.LadderFloor;
import ladder.domain.participant.Participant;
import ladder.domain.participant.Participants;

import java.util.Arrays;
import java.util.List;

public final class ResultView {
    private static final String PRINT_LINE = "-----|";
    private static final String PRINT_NO_LINE = "     |";
    private static final String FORMAT_GAME_RESULT = "\n실행 결과\n";
    private static final String FORMAT_NAME = "%6s";
    private static final String FORMAT_LADDER_RESULT = "\n사다리 결과\n\n";

    public static void printLadder(final List<Participant> participants, final List<LadderFloor> ladderFloors) {
        System.out.printf(FORMAT_LADDER_RESULT);

        printNames(participants);
        printFloors(ladderFloors);
    }

    static void printNames(final List<Participant> participants) {
        participants.stream()
                .map((participant) -> participant.toStringName())
                .forEach(ResultView::printName);

        printLineFeed();
    }

    static void printName(final String name) {
        System.out.printf(String.format(FORMAT_NAME, name));
    }

    static void printFloors(final List<LadderFloor> ladderFloors) {
        ladderFloors.stream().forEach(ResultView::printFloor);
    }

    static void printFloor(final LadderFloor ladderFloor) {
        printNoLine();

        ladderFloor.getLines()
                .stream()
                .forEach(ResultView::printColumn);

        printLineFeed();
    }

    static void printColumn(final boolean line) {
        if (line == true) {
            printLine();
            return;
        }

        printNoLine();
    }

    static void printLine() {
        System.out.print(PRINT_LINE);
    }

    static void printNoLine() {
        System.out.print(PRINT_NO_LINE);
    }

    static void printLineFeed() {
        System.out.println();
    }

    public static void printResult(Participants participants, String nameForResult, GameResult gameResult) {
        System.out.printf(FORMAT_GAME_RESULT);

        if (nameForResult.equals("all")) {
            printResultAll(participants.getNameOfParticipants(), gameResult);
            return;
        }

        printResultOfPrize(nameForResult, gameResult.findResult(nameForResult));
    }

    private static void printResultAll(String[] nameOfParticipants, GameResult gameResult) {
        for (String name : nameOfParticipants) {
            printResultOfPrize(name, gameResult.findResult(name));
        }
    }

    private static void printResultOfPrize(String nameOfParticipant, String prize) {
        System.out.println(nameOfParticipant + " : " + prize);
    }

    public static void printLadderPrize(String[] ladderPrizeNames) {
        Arrays.stream(ladderPrizeNames).forEach(ResultView::printName);
        printLineFeed();
    }
}
