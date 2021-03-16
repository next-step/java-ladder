package ladder.utils;

public class StringUtil {

    public static boolean isBlank(String string) {
        if (string == null || string.trim().isEmpty()) {
            return true;
        }
        return false;
    }

}
