package nextstep.ladder.util;

public class StringUtil {

    public static String appendWhiteSpaceInside(String text, int length) {
        return String.format(new StringBuilder()
                .append("%")
                .append(length)
                .append("s")
                .toString(), text);
    }
}
