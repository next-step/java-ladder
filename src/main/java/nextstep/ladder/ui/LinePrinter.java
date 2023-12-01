package nextstep.ladder.ui;

public class LinePrinter {

    private final String COLUMN_SIGN = "|";
    private final String ROW_SIGN = "-";
    private final String EMPTY_ROW_SIGN = " ";
    private int repeatNumber;

    /**
     * repeatNumber -> highCount
     */
    public LinePrinter(int repeatNumber) {
        this.repeatNumber = repeatNumber;
    }

    public void printRefactoring(boolean isTruePosition) {
        if (isTruePosition) {
            System.out.print(ROW_SIGN.repeat(repeatNumber) + COLUMN_SIGN);
            return;
        }
        System.out.print(EMPTY_ROW_SIGN.repeat(repeatNumber) + COLUMN_SIGN);
    }
}
