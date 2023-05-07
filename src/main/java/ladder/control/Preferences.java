package ladder.control;

public class Preferences {

    public static String userDelimiter() {
        return ", ";
    }

    public static int lineCount(int width) {
        return width * 2 - 1;
        // 예시에서 4명 입력시 7개인걸 기준으로 해당 정책을 세움. 추후 변경 가능
    }
}
