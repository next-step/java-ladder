package ladder.view;


import ladder.domain.Ladder;
import ladder.domain.User;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_TITLE = "실행결과";
    private static final String LADDER_VERTICAL_STRING = "|";
    private static final String LADDER_HORIZON_STRING = "-";
    private static final String EMPTY = "";
    private static final String SPACE = " ";

    private static final String FIRST_USER_STRING_FORMAT = "%-" + User.NAME_LENGTH_LIMIT + "s";
    private static final String NORMAL_USER_STRING_FORMAT = "%" + User.NAME_LENGTH_LIMIT + "s";

    public static void printTitle() {
        System.out.println(OUTPUT_TITLE);
        System.out.println();
    }

    public static void printUsers(List<User> users) {
        String text = users.stream().map(User::getName)
                .reduce(EMPTY, (userName1, userName2) -> {
                    if(userName1.equals(EMPTY)) {
                        return String.format(FIRST_USER_STRING_FORMAT, userName2);
                    }
                    return userName1 + SPACE + String.format(NORMAL_USER_STRING_FORMAT, userName2);
                }).trim();
        System.out.println(text);
    }

    public static void printLadder(Ladder ladder) {
        for(int i = 0 ; i < ladder.getHeight() ; i++) {
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

}
