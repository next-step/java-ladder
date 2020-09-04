package nextstep.ladder.util;

public class StringUtils {

    private final static String USER_SEPERATOR = ",";

    private StringUtils() {
    }

    public static String[] splitUsers(String users) {
        return users.split(USER_SEPERATOR);
    }
}
