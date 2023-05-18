package ladder.control;

public class Preferences {


    private static final int MAX_COLUMN_AND_USER_COUNT = 50;
    private static final int MAX_ROW_AND_RADDER_HEIGHT = 50;
    private static final String SHAPE_OF_PILLAR = "|";
    private static final String SHAPE_OF_EMPTY_LINE = "      ";
    private static final String SHAPE_OF_ALLOCATED_LINE = "------";
    private static final int INFINITE_LOOP_THRESHOLD = 10000;
    private static final int LADDER_COLUMN_CLAMP_SIZE = 1;

    private Preferences() {
    }

    public static int maxColumnPolicy() {
        return MAX_COLUMN_AND_USER_COUNT;
    }

    public static int maxRowPolicy() {
        return MAX_ROW_AND_RADDER_HEIGHT;
    }

    public static String userDelimiter() {
        return ", ";
    }

    public static int createLineCount(int column, int row) {
        int min = Math.min(canCreateAnyCasePolicy(column, row), defaultLadderCreatePolicy(column));
        System.out.printf("사다리 Line 은 %d 개 만듭니다%s", min, System.lineSeparator());
        return min;
    }

    private static int canCreateAnyCasePolicy(int column, int row) {
        return ((column - 1) / 2) * row;
        // 예시에서 참가자 4명, 7개사다리, 높이5 였는데
        // 참가자4명, 높이5 일때, 사다리 7개를 만들지 못하는 경우가 발생함. 이에 무조건 사다리를 만들수 있는 수로만 사다리의 생성을 제한함
    }

    private static int defaultLadderCreatePolicy(int column) {
        return column * 2 - 1;
    }

    public static int maxUserCount() {
        return MAX_COLUMN_AND_USER_COUNT;
    }

    public static int maxLadderHeight() {
        return MAX_ROW_AND_RADDER_HEIGHT;
    }

    public static String pillarShape() {
        return SHAPE_OF_PILLAR;
    }

    public static String allocatedLineShape() {
        return SHAPE_OF_ALLOCATED_LINE;
    }

    public static String emptyLineShape() {
        return SHAPE_OF_EMPTY_LINE;
    }

    public static int circuitBreakerTriggerLoopCount() {
        return INFINITE_LOOP_THRESHOLD;
    }

    public static int ColumnClampingSize() {
        return LADDER_COLUMN_CLAMP_SIZE;
    }
}
