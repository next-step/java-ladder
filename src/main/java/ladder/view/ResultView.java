package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PRINT_FORMAT = "%6s";
    private static final String ALL_PARTICIPANTS = "all";

    public static void showParticipants(Participants participants) {
        List<String> names = participants.names()
                .stream()
                .map(name -> String.format(PRINT_FORMAT, name))
                .collect(Collectors.toList());
        System.out.println(String.join("", names));
    }

    public static void showLadder(LadderStrategy ladder) {
        ladder.getLines()
                .stream()
                .map(ResultView::lineToString)
                .forEach(System.out::println);
    }

    private static String lineToString(Line line) {
        StringJoiner joiner = new StringJoiner("|", "     |", "|");
        line.getBridge()
                .stream()
                .map(ResultView::bridgeToString)
                .forEach(joiner::add);
        return joiner.toString();
    }

    private static String bridgeToString(Boolean bridge) {
        return bridge ? "-----" : "     ";
    }

    public static void showGamePrize(GamePrize gamePrize) {
        List<String> prizeList = gamePrize.prizeList()
                .stream()
                .map(prize -> String.format(PRINT_FORMAT, prize))
                .collect(Collectors.toList());
        System.out.println(String.join("", prizeList));
    }

    public static void showGameResult(GameResult gameResult, String participantForResult) {
        if (participantForResult.equals(ALL_PARTICIPANTS)) {
            gameResult.getResult()
                    .forEach((key, value) -> System.out.println(key + " : " + value));
            return;
        }

        System.out.println(gameResult.getResult().get(new Name(participantForResult)));

    }

}
