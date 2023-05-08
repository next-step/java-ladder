package ladder.control;

public class Preferences {

    private static final int MAX_COLUMN = 50;
    private static final int MAX_ROW = 50;

    public static int maxColumnPolicy() {
        return MAX_COLUMN;
    }

    public static int maxRowPolicy() {
        return MAX_ROW;
    }

    public static String userDelimiter() {
        return ", ";
    }

    public static int createLineCount(int column, int row) {
        int min = Math.min(canCreateAnyCasePolicy(column, row), defaultLadderCreatePolicy(column));
        System.out.printf("사다리는 %d개 만듭니다\n",min);
        return min;
    }

    private static int canCreateAnyCasePolicy(int column, int row) {
        return  ((column - 1) / 2) * row;
        // 예시에서 참가자 4명, 7개사다리, 높이5 였는데
        // 참가자4명, 높이5 일때, 사다리 7개를 만들지 못하는 경우가 발생함. 이에 무조건 사다리를 만들수 있는 수로만 사다리의 생성을 제한함
    }

    private static int defaultLadderCreatePolicy(int column) {
        return column * 2 - 1;
    }
}
