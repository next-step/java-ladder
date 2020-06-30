package ladder.utils;

public class InputUtils {

    public static void isEmptyOrNull(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("공백이거나 비어있을수 없습니다.");
        }
    }
}
