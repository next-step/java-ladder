package ladder.view;

import ladder.domain.GamePrize;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Participants;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PRINT_FORMAT = "%6s";

    public static void showParticipants(Participants participants) {
        List<String> names = participants.names()
                .stream()
                .map(name -> String.format(PRINT_FORMAT, name))
                .collect(Collectors.toList());
        System.out.println(String.join("", names));
    }

    public static void showLadder(Ladder ladder) {
        ladder.getLines()
                .stream()
                .map(ResultView::lineToString)
                .forEach(System.out::println);
    }

    public static void showGamePrize(GamePrize gamePrize) {
        List<String> prizeList = gamePrize.getPrize()
                .stream()
                .map(prize -> String.format(PRINT_FORMAT, prize))
                .collect(Collectors.toList());
        System.out.println(String.join("", prizeList));
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
}
