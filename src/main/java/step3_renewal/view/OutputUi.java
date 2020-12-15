package step3_renewal.view;


import step3_renewal.domain.*;
import step3_renewal.utils.StringUtil;

import java.util.stream.IntStream;

public class OutputUi {
    public static final String PRINT_RESULT = "실행 결과";
    private static final String EMPTY = "";
    private static final Integer REPEAT = 5;
    private static final String STEP = "|";
    private static final String LINE = "-----";
    private static final String NO_LINE = "     ";

    public static void printAll(Participants names, Rewards reward, Ladder ladder) {
        System.out.println("사다리 결과");
        printParticipants(names);
        printLadderLine(ladder);
        printLadderGameOneResult(reward);
    }

    private static void printParticipants(Participants participants) {
        participants.getParticipants()
                .stream()
                .map(name -> StringUtil.padLeft(REPEAT, name.getParticipantName()) + EMPTY)
                .forEach(System.out::print);
        System.out.println();
    }

    public static void printLadderLine(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        ladder.getLadderLines()
                .forEach(line -> lineBuilder(sb, line));
        System.out.println(sb);
    }

    private static void lineBuilder(StringBuilder ladder, LadderLine line) {
        IntStream.range(0, line.getPoints().size())
                .forEach(i -> printLadderLine(ladder, line.getPoints().get(i)));
        ladder.append("\n");
    }

    private static void printLadderLine(StringBuilder ladder, Point point) {
        if (point.isDrawLine()) {
            ladder.append(LINE);
            ladder.append(STEP);
            return;
        }
        ladder.append(NO_LINE);
        ladder.append(STEP);
    }

    private static void printLadderGameOneResult(Rewards reward) {
        reward.getRewards().stream()
                .map(e -> StringUtil.padLeft(REPEAT, e.getName()) + EMPTY)
                .forEach(System.out::print);
        System.out.println();
    }

    public static void printLadderGameAllResult(GameResults gameResults) {
        System.out.println(PRINT_RESULT);
        gameResults.getGameResults()
                .stream()
                .map(gameResult ->
                        gameResult.getParticipantName() + ":" + gameResult.getReward().getName())
                .forEach(System.out::println);
    }

    private static void printLadderGameOneResult(String participantName, GameResults gameResults) {
        System.out.println(PRINT_RESULT);
        gameResults.getGameResults()
                .stream()
                .filter(rewardMatch -> rewardMatch.getParticipantName().equals(participantName))
                .map(rewardMatch -> rewardMatch.getReward().getName())
                .forEach(System.out::println);
    }

    public static void printLadderGameResult(String participantName, GameResults gameResults) {
        while (!participantName.equalsIgnoreCase("all")) {
            printLadderGameOneResult(participantName, gameResults);
            participantName = InputUi.wantToSeeResult();
        }
        printLadderGameAllResult(gameResults);
    }
}
