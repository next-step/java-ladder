package ladder.view;

import java.util.List;
import ladder.domain.user.User;

public class ResultView {

    private ResultView() {
    }

    public static void printUsers(List<User> users) {
        for (User user: users) {
            System.out.printf("%-6s", user.nameToString());
        }
        System.out.println();
    }

}
