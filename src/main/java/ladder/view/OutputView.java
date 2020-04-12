package ladder.view;

import ladder.domain.*;

public class OutputView {
    private static final String TAB = "    ";
    private static final String WIDTH_DRAW_SUCCESS = "-----";
    private static final String WIDTH_DRAW_FAIL = "     ";
    private static final String VERTICAL = "|";
    private static final String BLANK = " ";
    private static final int MAX_NAME_LENGTH = 5;

    public static void printNames(Users users) {
        StringBuilder sb = new StringBuilder();
        sb.append(BLANK);
        for (User user : users.getUsers()) {
            sb.append(makeSpace(user.getName()));
        }
        System.out.println(sb.toString());
    }

    public static void printLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();

        for (Line line : ladder.getLines()) {
            printLines(sb, line);
        }
        System.out.print(sb.toString());
    }

    private static void printLines(StringBuilder sb, Line line) {
        sb.append(TAB);

        for (Boolean canDrawWidth : line.getWidthLines()) {
            sb.append(VERTICAL);
            sb.append(canDrawWidth ? WIDTH_DRAW_SUCCESS : WIDTH_DRAW_FAIL);
        }
        sb.append(VERTICAL);
        sb.append(System.lineSeparator());
    }

    public static void printResult(LadderGoals ladderGoals) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ladderGoals.size(); i++) {
            sb.append(ladderGoals.getResult(i) + TAB);
        }
        System.out.println(sb.toString());
    }

    /**
     * 이름 출력시 5글자까지 반복하여 공백을 더해준다.
     *
     * @param userName
     * @return
     */
    private static String makeSpace(String userName) {
        if (userName.length() > MAX_NAME_LENGTH) {
            return userName;
        }
        if (userName.length() % 2 == 1) {
            return makeSpace(userName + BLANK);
        }
        return makeSpace(BLANK + userName);
    }

}
