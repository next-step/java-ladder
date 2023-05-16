package nextstep.ladder.domain;


public class ResultView {
    private static final String COLUMN = "|";
    private static final String LINE = "_____";
    private static final String EMPTY_LINE = "     ";
    private Ladder ladder;


    public ResultView(Ladder ladder) {
        this.ladder = ladder;
    }

    public ResultView() {
    }

    public void printLadder() {
        for (User user : ladder.getUsers().getUsers()) {
            System.out.print(user.getName() + EMPTY_LINE);
        }
        System.out.println("");
        for (Row row : ladder.getRows().getPoints()) {
            printRow(row);
            System.out.println("");
        }
        for (String result : ladder.getResults().getResults()) {
            System.out.print(result + EMPTY_LINE);
        }
    }

    public void printResult(String name, boolean isAll) {
        System.out.println("실행결과");
        System.out.println(getResult(name, isAll));
    }

    public String getResult(String name, boolean isAll) {
        String result = "";
        if (isAll) {
            for (User user : ladder.getUsers().getUsers()) {
                result += user.getName() + " : " + user.getResult() + "\n";
            }
            return result;
        }
        return name + " : " + ladder.getUsers().getResultByName(name);
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
