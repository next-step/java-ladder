package step2.view;

import step2.domain.*;

import java.util.List;

public class ResultView {
    private static final int NAME_MAX_LENGTH = 5;
    private static final String RESULT_MESSAGE = "실행결과\n";
    private static final String WHITE_SPACE = " ";
    private static final String WHITE_SPACE_FOUR = "    ";
    private static final String LADDER_WHITE_SPACE = "     ";
    private static final String LADDER = "|";
    private static final String LINE = "-----";
    private static final String LADDER_LINE = LADDER + LINE;
    private static final String LADDER_NO_LINE = LADDER + LADDER_WHITE_SPACE;

    public static void showResult(Participants participants, Ladder ladder, Rewards rewards) {
        System.out.println(RESULT_MESSAGE);
        showParticipantNames(participants.getNames());
        showLadder(ladder);
        showRewards(rewards.getRewards());
    }

    public static void showRewardResult(String result) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(result);
    }

    public static void showRewardAllResult(String result) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(result);
    }

    private static void showParticipantNames(List<String> names) {
        for (String name : names) {
            int nameLength = name.length();
            System.out.print(repeatWhiteSpace(NAME_MAX_LENGTH - nameLength) + name + WHITE_SPACE);
        }
        System.out.println();
    }

    private static void showLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            System.out.print(WHITE_SPACE_FOUR);
            showLine(line);
        }
    }

    private static void showLine(Line line) {
        for (Boolean isLine : line.getLine()) {
            printLine(isLine);
        }
        System.out.println();
    }

    private static void printLine(Boolean isLine) {
        if (isLine) {
            System.out.print(LADDER_LINE);
            return;
        }
        System.out.print(LADDER_NO_LINE);
    }

    private static void showRewards(String[] rewards) {
        for (String reward : rewards) {
            int rewardLength = reward.length();
            System.out.print(repeatWhiteSpace(NAME_MAX_LENGTH - rewardLength) + reward + WHITE_SPACE);
        }
        System.out.println();
    }

    private static String repeatWhiteSpace(int repeatCount) {
        StringBuilder sb = new StringBuilder();
        for (int count = 0; count < repeatCount; count++) {
            sb.append(WHITE_SPACE);
        }
        return sb.toString();
    }
}
