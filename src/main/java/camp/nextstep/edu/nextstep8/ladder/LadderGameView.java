package camp.nextstep.edu.nextstep8.ladder;

public class LadderGameView {
    private static final String LINE = "-----";
    private static final String SPACE = "     ";

    public void show(Ladder ladder) {
        // System.out.printf("%-5s %-5s %-5s %-5s\n", "MEMBER", "", "", "" );
        for(int i = 0; i < ladder.getMap().length; i++) {
            for(int j = 0; j < ladder.getMap()[i].length; j++) {
                System.out.print("|");
                System.out.print(getPrintLine(i, j));
            }
            System.out.println();
        }
    }

    private String getPrintLine(int row, int order) {
        if(canPrintLine(row, order)) {
            return LINE;
        }
        return SPACE;
    }

    private boolean canPrintLine(int row, int order) {
        if(meetLastOrder(order)) {
            return false;
        }
        return points[row][order].isStart() && points[row][order + 1].isEnd();
    }

    private boolean meetLastOrder(int now) {
        int next = now + 1;
        if(cols <= next) {
            return true;
        }
        return false;
    }
}
