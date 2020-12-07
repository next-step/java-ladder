package ladder.view;

import ladder.domain.*;

import java.util.stream.Collectors;

import static ladder.domain.LadderGameConfig.PLAYER_NAME_MAX_LENGTH;

public class ResultView {

    private static final String BUILD_HEAD_MESSAGE = "\n사다리 결과\n";
    private static final String RESULT_HEAD_MESSAGE = "\n실행결과\n";
    private static final String CONNECTED = "-----";
    private static final String EMPTY = "";
    private static final String NOT_CONNECTED = padLeftZeros(EMPTY, 5);
    private static final String LADDER = "|";
    private static final String SPACE = " ";

    private ResultView(){}

    public static void showBuildResult(LadderBuildResult ladderBuildResult, Awards awards) {
        System.out.println(BUILD_HEAD_MESSAGE);

        showPlayers(ladderBuildResult.getPlayers());
        showLadders(ladderBuildResult.getLadders());
        showAwards(awards);

    }

    private static void showAwards(Awards awards) {

        awards.getAwards().stream()
                .map(award -> padLeftZeros(award.getAwardName(),PLAYER_NAME_MAX_LENGTH) + SPACE)
                .forEach(System.out::print);
        System.out.println();
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
                .map(i-> LADDER+(i.getDirection().isRight()? CONNECTED:NOT_CONNECTED)).collect(Collectors.joining());
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
