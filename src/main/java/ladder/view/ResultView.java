package ladder.view;

import ladder.model.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    public static void printLadder(Participants participants, Ladder ladder, ResultItems resultItems) {
        System.out.println("사다리 결과");

        printParticipants(participants.getParticipants());
        ladder.getLines().stream()
                .forEach(line -> printLine(line.getPoints()));
        printResultItems(resultItems.getResultItems());
    }

    public static void printGameResult(GameResult ladderGameResult, String name) {
        System.out.println("실행 결과");

        if (name.equals("all")) {
            ladderGameResult.getGameResultItems().stream()
                    .forEach(gameResultItem -> printGameResult(gameResultItem));
            return;
        }

        printResultItem(ladderGameResult.getResult(name));
    }

    private static void printResultItem(GameResultItem gameResultItem) {
        System.out.println(gameResultItem.getResultName());
    }

    private static void printGameResult(GameResultItem gameResultItem) {
        System.out.println(gameResultItem.getName() + " : " + gameResultItem.getResultName());
    }

    private static void printParticipants(List<Participant> participants) {
        System.out.println(participants.stream()
                .map(participant -> adjustValue(participant.toString())).collect(Collectors.joining(" ")));
    }

    private static void printResultItems(List<ResultItem> resultItems) {
        System.out.println(resultItems.stream()
                .map(resultItem -> adjustValue(resultItem.toString())).collect(Collectors.joining(" ")));
    }

    private static void printLine(List<Point> points) {
        System.out.println(points.stream()
                .limit(points.size() - 1)
                .map(point -> point.isRight() ? "-----" : "     ")
                .collect(Collectors.joining("|", "    |", "|")));
    }

    private static String leftWhitespacePad(String value, int countOfPad) {
        return IntStream.range(0, countOfPad)
                .mapToObj(index -> " ").collect(Collectors.joining()) + value;
    }

    private static String adjustValue(String value) {
        int countOfLeftPad = 5 - value.length();
        return countOfLeftPad > 0 ? leftWhitespacePad(value, countOfLeftPad) : value;
    }
}
