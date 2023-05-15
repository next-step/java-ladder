package nextstep.ladder.domain;


public class ResultView {
    private static final String COLUMN = "|";
    private static final String LINE = "_____";
    private static final String EMPTY_LINE = "     ";

    public void printLadder(Ladder ladder) {
        for (User user : ladder.getUsers().getUsers()) {
            System.out.print(user.getName() + EMPTY_LINE);
        }
        System.out.println("");
        for (Row row : ladder.getPoints().getPoints()) {
            printRow(row);
            System.out.println("");
        }
    }

    public void printRow(Row row) {
        for (Point point : row.getRow()) {
            System.out.print(COLUMN);
            System.out.print(getLine(point));
        }
    }

    public String getLine(Point point) {
        if (point.movableRight()) {
            return LINE;
        }
        return EMPTY_LINE;
    }
}
