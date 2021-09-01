package nextstep.ladder.view;

public class OutPutViewUtils {

    private static final int STRING_SPACE = 6;
    private static final String STRING_PADDING = " ";

    private OutPutViewUtils() {

    }

    public static String appendPaddingBeforeValue(String value) {
        int valueLength = value.length();
        if (valueLength < STRING_SPACE) {
            int paddingLength = STRING_SPACE - valueLength;
            return appendPaddingBeforeValue(value, paddingLength);
        }
        return value;
    }

    public static String appendPaddingAfterValue(String value) {
        int valueLength = value.length();
        if (valueLength < STRING_SPACE) {
            int paddingLength = STRING_SPACE - valueLength;
            return appendPaddingAfterValue(value, paddingLength);
        }
        return value;
    }

    public static String appendPaddingBeforeValue(String value, int paddingLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < paddingLength; i++) {
            stringBuilder.append(STRING_PADDING);
        }
        stringBuilder.append(value);
        return stringBuilder.toString();
    }

    public static String appendPaddingAfterValue(String value, int paddingLength) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(value);
        for (int i = 0; i < paddingLength; i++) {
            stringBuilder.append(STRING_PADDING);
        }
        return stringBuilder.toString();
    }


}
