package ladder.util;

import java.util.List;

public class StringUtil {
    public static List<String> parseUserList(String userList) {
        String[] users = userList.split(",");
        return List.of(users);
    }
}
