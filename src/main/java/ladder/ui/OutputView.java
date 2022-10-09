package ladder.ui;

import ladder.model.LineUnit;
import ladder.model.User;
import ladder.model.Users;

public abstract class OutputView {

    private static final int LADDER_USER_INTERVAL = 6;
    private static final String LADDER_WITH_NO_SPACE = " ";
    private static final String HORIZONTAL_UNIT = "-";
    private static final String VERTICAL_UNIT = "|";

    public static void printLadder(Users users, int lineLength) {
        printName(users);
        System.out.println();
        printLine(users, lineLength);
    }

    private static void printName(Users users) {
        for (int i = 0; i < users.size(); i++) {
            printSingleName(users, i);
        }
    }

    private static void printSingleName(Users users, int index) {
        String username = getNameOfUser(users.getUsers().get(index));
        if (index == 0) {
            System.out.print(username);
            return;
        }
        System.out.print(addDelimiter(LADDER_USER_INTERVAL - username.length(), LADDER_WITH_NO_SPACE) + username);
    }

    private static void printLine(Users users, int length) {
        for (int i = 0; i < length; i++) {
            printSingleLine(users, i);
            System.out.println();
        }
    }

    private static void printSingleLine(Users users, int index) {
        for (int i = 0; i < users.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            User user = users.getUsers().get(i);
            String username = getNameOfUser(user);
            LineUnit unit = user.getVerticalLine().getLineUnits().get(index);
            appendSingleLine(i, stringBuilder, username, unit);
            System.out.print(stringBuilder);
        }
    }

    private static void appendSingleLine(int index, StringBuilder stringBuilder, String username, LineUnit unit) {
        if (index == 0) {
            stringBuilder.append(addDelimiter(username.length(), LADDER_WITH_NO_SPACE) + VERTICAL_UNIT);
            return;
        }
        if (unit.hasPrevious()) {
            stringBuilder.append(addDelimiter(LADDER_USER_INTERVAL - 1, HORIZONTAL_UNIT) + VERTICAL_UNIT);
            return;
        }
        stringBuilder.append(addDelimiter(LADDER_USER_INTERVAL - 1, LADDER_WITH_NO_SPACE) + VERTICAL_UNIT);
    }

    private static String addDelimiter(int length, String delimiter) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(delimiter);
        }
        return stringBuilder.toString();
    }

    private static String getNameOfUser(User user) {
        return user.getName().getName();
    }
}
