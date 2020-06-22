package ladder.view;

import ladder.domain.ladder.Direction;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderLine;
import ladder.domain.participants.Participants;
import ladder.domain.result.GameResult;
import ladder.domain.result.Results;

import java.util.stream.IntStream;

import static ladder.utils.LadderUtil.fillSpace;

public class ResultView {

    public static final String POINT_TRUE = "-----|";
    public static final String POINT_FALSE = "     |";

    private ResultView() {
    }

    public static void printLadder(Participants participants, Ladder ladder, Results results) {
        System.out.println("\n사다리 결과\n");
        printParticipants(participants);
        for (LadderLine line : ladder.getLadder()) {
            printLadderPoint(line);
            System.out.println();
        }
        printResults(results);
    }

    private static void printParticipants(Participants participants) {
        IntStream.range(0, participants.size())
                .mapToObj(i -> fillSpace(participants.tellPersonName(i)))
                .forEach(System.out::print);
        System.out.println();
    }

    private static void printLadderPoint(LadderLine ladderLine) {
        ladderLine.getPoints().stream()
                .map(point -> drawLine(point.getDirection()))
                .forEach(System.out::print);
    }

    private static String drawLine(Direction direction) {
        if (direction.isLeft()) {
            return POINT_TRUE;
        }
        return POINT_FALSE;
    }

    private static void printResults(Results results) {
        results.getResults().stream()
                .map(result -> fillSpace(result.getResult()))
                .forEach(System.out::print);
        System.out.println();
    }

    public static void printResult(GameResult gameResult) {
        String findName = InputView.enterCuriousResult();

        while (!findName.equals("all")) {
            String findResult = gameResult.findResult(findName);
            System.out.println("\n실행 결과\n" + findResult);
            findName = InputView.enterCuriousResult();
        }

        System.out.println("\n실행 결과");
        gameResult.getGameResult()
                .forEach((person, result) -> System.out.println(person.getName() + " : " + result.getResult()));
    }
}
