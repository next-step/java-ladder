package ladder.utils;

public class InputUtils {

    public static String isEmptyOrNull(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("공백이거나 비어있을수 없습니다.");
        }

        return text;
    }
}
