package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderGameResult;
import ladder.domain.Ladders;
import ladder.domain.Players;

import java.util.stream.Collectors;

import static ladder.domain.LadderGameConfig.PLAYER_NAME_MAX_LENGTH;

public class ResultView {

    private static final String RESULT_HEAD_MESSAGE = "\n실행결과\n";
    private static final String CONNECTED = "-----";
    private static final String EMPTY = "";
    private static final String NOT_CONNECTED = padLeftZeros(EMPTY, 5);
    private static final String LADDER = "|";
    private static final String SPACE = " ";

    private ResultView(){}

    public static void showResult(LadderGameResult ladderGameResult) {
        System.out.println(RESULT_HEAD_MESSAGE);

        showPlayers(ladderGameResult.getPlayers());
        showLadders(ladderGameResult.getLadders());
    }

    private static void showLadders(Ladders ladders) {
        ladders.getLadders().stream()
                .forEach(ladder -> {
                    System.out.print(padLeftZeros(EMPTY, 5));
                    System.out.println(showLadder(ladder));
                });
    }

    private static String showLadder(Ladder ladder) {
        return ladder.getLine().getPoints().stream()
                .map(i-> LADDER+(i? CONNECTED:NOT_CONNECTED)).collect(Collectors.joining());
    }

    private static void showPlayers(Players players) {
        players.getPlayers().stream()
                .map(player -> padLeftZeros(player.getName(),PLAYER_NAME_MAX_LENGTH) + SPACE)
                .forEach(System.out::print);
        System.out.println();
    }

    public static String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }

        StringBuilder sb = new StringBuilder();

        while (sb.length() < length - inputString.length()) {
            sb.append(SPACE);
        }

        sb.append(inputString);

        return sb.toString();
    }
}
