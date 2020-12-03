package step2.view;


import step2.domain.*;
import step2.hint.LadderLine;

import java.util.stream.Collectors;

public class OutputView {
    public static final String PRINT_LADDER_RESULT = "사다리 결과";
    public static final String PRINT_RESULT = "실행 결과";
    private static final String HEIGHT_LINE = "|";
    private static final String PLAY_LINE = "-----";
    private static final String PLAY_NO_LINE = "     ";
    public static final String BLANK = "     ";
    public static final String NAME_FORMATTER = "%-6s";
    public static final String SPLIT = ":";

    private OutputView() {
    }

    public static void printLadderResult() {
        System.out.println(PRINT_LADDER_RESULT);
    }


    public static void printPlayers(Players players) {
        System.out.print(BLANK);
        System.out.println(players.getPlayers()
                .stream()
                .map(Player::getPlayerGameName)
                .map(name -> String.format(NAME_FORMATTER, name))
                .collect(Collectors.joining()));
    }

    public static void printLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        ladder.getLines()
                .forEach(line -> lineBuilder(sb, line));
        System.out.println(sb);
    }

    private static void lineBuilder(StringBuilder ladder, LadderLine line) {
        line.getPoints()
                .forEach(point -> {
                    if (point.getDirection().isLeft()) {
                        ladder.append(PLAY_LINE);
                        ladder.append(HEIGHT_LINE);
                        return;
                    }
                    ladder.append(PLAY_NO_LINE);
                    ladder.append(HEIGHT_LINE);


                });
        ladder.append("\n");
    }

    public static void printRewards(Rewards rewards) {
        System.out.print(BLANK);
        System.out.println(rewards.getRewards()
                .stream()
                .map(Reward::getRewardName)
                .map(name -> String.format(NAME_FORMATTER, name))
                .collect(Collectors.joining()));
    }

    public static void printPlayerReward(GameResults gameResults, String player) {
        System.out.println(PRINT_RESULT);
        gameResults.getGameResults()
                .forEach(playerRewardMatch -> printPlayerReward(player, playerRewardMatch));
    }

    private static void printPlayerReward(String player, GameResult gameResult) {
        if (gameResult.getPlayerGameName().equals(player)) {
            printPlayerReward(gameResult, player);
        }
    }

    public static void printAllPlayerReward(GameResults gameResults) {
        gameResults.getGameResults()
                .forEach(playerRewardMatch -> printPlayerReward(playerRewardMatch, playerRewardMatch.getPlayerGameName()));
    }

    private static void printPlayerReward(GameResult gameResult, String playerGameName) {
        System.out.println(playerGameName + SPLIT + gameResult.getRewardName());
    }
}
