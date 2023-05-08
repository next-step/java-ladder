package ladder.control;

public class Preferences {

    public static String userDelimiter() {
        return ", ";
    }

    public static int createLineCount(int width, int row) {
        return Math.min(canCreateAnyCasePolicy(width, row), defaultLaddeCreatePolicy(width));
    }

    private static int canCreateAnyCasePolicy(int width, int row) {
        return  ((width - 1) / 2) * row;
        // 예시에서 참가자 4명, 7개사다리, 높이5 였는데
        // 참가자4명, 높이5 일때, 사다리 7개를 만들지 못하는 경우가 발생함. 이에 무조건 사다리를 만들수 있는 수로만 사다리의 생성을 제한함
    }

    private static int defaultLaddeCreatePolicy(int width) {
        return width * 2 - 1;
    }
}
