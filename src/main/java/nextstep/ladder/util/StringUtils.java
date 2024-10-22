package nextstep.ladder.util;

public class StringUtils {

    private StringUtils() {
        throw new UnsupportedOperationException("유틸 클래스는 생성할 수 없습니다.");
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static String lPad(String content, int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = content.length(); i < length; i++) {
            builder.append(" ");
        }
        return builder + content;
    }
}
