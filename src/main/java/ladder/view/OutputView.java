package ladder.view;


import ladder.domain.Ladder;
import ladder.domain.LadderPrize;
import ladder.domain.Participants;
import ladder.domain.User;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_TITLE = "실행결과";
    private static final String OUTPUT_LADDER_TITLE = "사다리 결과";

    private static final String LADDER_VERTICAL_STRING = "|";
    private static final String LADDER_HORIZON_STRING = "-";
    private static final String EMPTY = "";
    private static final String SPACE = " ";

    private static final String LEFT_GRAVITY_STRING_FORMAT = "%-" + User.NAME_LENGTH_LIMIT + "s";
    private static final String RiGHT_GRAVITY_STRING_FORMAT = "%" + User.NAME_LENGTH_LIMIT + "s";

    private static void printResultTitle() {
        System.out.println(OUTPUT_TITLE);
        System.out.println();
    }

    private static void printLadderTitle() {
        System.out.println(OUTPUT_LADDER_TITLE);
        System.out.println();
    }

    private static void printUsers(List<User> users) {
        String text = users.stream().map(User::toString)
                .reduce(EMPTY, (userName1, userName2) -> {
                    if (userName1.equals(EMPTY)) {
                        return String.format(LEFT_GRAVITY_STRING_FORMAT, userName2);
                    }
                    return userName1 + SPACE + String.format(RiGHT_GRAVITY_STRING_FORMAT, userName2);
                }).trim();
        System.out.println(text);
    }

    public static void printLadder(Participants participants, Ladder ladder, List<LadderPrize> ladderPrizes) {
        printLadderTitle();
        printUsers(participants.getUserAll());
        printLadderSkeleton(ladder);
        printLadderPrizes(ladderPrizes);
    }

    private static void printLadderSkeleton(Ladder ladder) {
        for (int i = 0 ; i < ladder.getHeight() ; i++) {
            System.out.println(getHorizonLine(ladder, i));
        }
    }

    private static String getHorizonLine(Ladder ladder, int heightIndex) {
        StringBuilder horizonLine = new StringBuilder();
        horizonLine.append("    ");
        for (int i = 0; i < ladder.getShortLineCountInHorizonLine(heightIndex); i++) {
            horizonLine.append(LADDER_VERTICAL_STRING);
            horizonLine.append(getShortLine(ladder.isEnabledShortLineOfRight(heightIndex, i)));
        }
        horizonLine.append(LADDER_VERTICAL_STRING);
        return horizonLine.toString();
    }

    private static String getShortLine(boolean isEnable) {
        StringBuilder shortLine = new StringBuilder();
        for (int i = 0; i < User.NAME_LENGTH_LIMIT ; i++) {
            shortLine.append(isEnable ? LADDER_HORIZON_STRING : SPACE);
        }
        return shortLine.toString();
    }

    private static void printLadderPrizes(List<LadderPrize> ladderPrizes) {
        String text = ladderPrizes.stream().map(LadderPrize::toString)
                .reduce(EMPTY, (s1, s2) -> s1 + SPACE + String.format(LEFT_GRAVITY_STRING_FORMAT, s2)).trim();
        System.out.println(text);
    }

    public static void printLadderResult(List<Integer> ladderPrizesIndex, List<LadderPrize> ladderPrizes, Participants participants) {
        printResultTitle();

        if(ladderPrizesIndex.size() == 1) {
            System.out.println(ladderPrizes.get(ladderPrizesIndex.get(0)));
        }
        else {
            for (int i = 0 ; i < ladderPrizesIndex.size() ; i++) {
                System.out.println(participants.getUser(i).toString() + ":" + ladderPrizes.get(ladderPrizesIndex.get(i)));
            }
        }
    }
}
