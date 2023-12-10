package nextstep.ladder;

public class OutputView {

    public static final int MAX_LADDER_WIDTH = 5;
    public static final String LADDER_BLANK_LINE = " ".repeat(MAX_LADDER_WIDTH);
    public static final String LADDER_ROW_LINE = "-".repeat(MAX_LADDER_WIDTH);
    public static final String LADDER_COLUMN_LINE = "|";

    public void printUserNameList(Users users) {
        for (User user : users.getUserList()) {
            System.out.print(getLadderSizeName(user));
            System.out.print(" ");
        }
        System.out.println();
    }

    public void printLadder(Ladder ladder) {
        ladder.lines().forEach(line -> {
            System.out.println(printLine(line));
        });
    }

    private String printLine(Line line) {
        StringBuilder ladderLine = new StringBuilder(LADDER_BLANK_LINE+LADDER_COLUMN_LINE);
        line.points().forEach(point ->  {
            ladderLine.append(point ? LADDER_ROW_LINE : LADDER_BLANK_LINE);
            ladderLine.append(LADDER_COLUMN_LINE);
        });
        return ladderLine.toString();
    }

    private String getLadderSizeName(User user) {
        String name = user.name();
        int length = name.length();
        if (length == MAX_LADDER_WIDTH) {
            return name;
        }
        return " ".repeat(MAX_LADDER_WIDTH - length) + name;
    }


}
