package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private Users users;
    private Lines lines;

    public LadderGame(Users users, Lines lines) {
        this.users = users;
        this.lines = lines;
    }

    public Users start() {

        List<User> userResults = new ArrayList<>();

        for (User user : this.users.userList()) {
            int startPosition = lines.calulateGameResult(user.position());
            User newUser = new User(user.name(), startPosition);
            userResults.add(newUser);
        }

        return new Users(userResults);
    }

}
