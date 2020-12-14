package ladder.view;

import ladder.domain.*;

import java.util.stream.Collectors;



public class ResultView {

    private static final int PLAYER_NAME_MAX_LENGTH = 5;
    private static final String ALL_RESULT_MESSAGE = "all";

    private static final String BUILD_HEAD_MESSAGE = "\n사다리 결과\n";
    private static final String RESULT_HEAD_MESSAGE = "\n실행결과";
    private static final String CONNECTED = "-----";
    private static final String EMPTY = "";
    private static final String NOT_CONNECTED = padLeftZeros(EMPTY, 5);
    private static final String LADDER = "|";
    private static final String SPACE = " ";
    private static final String RESULT_DELIMITER = " : ";
    private static final String ALL_RESULT_DELIMITER = "\n";

    private ResultView(){}

    public static void showBuildResult(LadderBuildResult ladderBuildResult, Awards awards) {
        System.out.println(BUILD_HEAD_MESSAGE);

        showPlayers(ladderBuildResult.getPlayers());
        showLadder(ladderBuildResult.getLadder());
        showAwards(awards);

    }

    private static void showAwards(Awards awards) {

        awards.getAwards().stream()
                .map(award -> padLeftZeros(award.getAwardName(),PLAYER_NAME_MAX_LENGTH) + SPACE)
                .forEach(System.out::print);
        System.out.println();
    }

    private static void showLadder(Ladder ladder) {

        ladder.getLines().stream()
                .forEach(line -> {
                    System.out.print(padLeftZeros(EMPTY, 5));
                    System.out.println(showLine(line));
                });

    }

    private static String showLine(Line line) {
        return line.getPoints().stream()
                .map(point -> makeConnectionLine(point)).collect(Collectors.joining());
    }


    private static String makeConnectionLine(Point point) {
        return LADDER + (point.getDirection().isRight()? CONNECTED:NOT_CONNECTED);
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

    public static void printPlayerResult(ClimbResults climbResult, String player) {
        System.out.println(RESULT_HEAD_MESSAGE);
        System.out.println(getPlayerResult(climbResult, player));
    }

    private static String getPlayerResult(ClimbResults climbResults, String playerName) {
        if(playerName.equals(ALL_RESULT_MESSAGE)){
            return climbResults.getClimbResults().stream()
                    .map(climbResult -> makeClimbResult(climbResult))
                    .collect(Collectors.joining(ALL_RESULT_DELIMITER));
        }

        return climbResults.matchAwardByPlayerName(playerName);

    }

    private static String makeClimbResult(ClimbResult climbResult) {
        return climbResult.getPlayer().getName() + RESULT_DELIMITER + climbResult.getAward().getAwardName();
    }


}
