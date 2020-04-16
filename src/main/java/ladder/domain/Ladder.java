package ladder.domain;

import ladder.domain.line.Lines;
import ladder.domain.user.User;
import ladder.domain.user.UserResult;
import ladder.domain.user.Users;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final List<Lines> ladder = new ArrayList<>();

    public static Ladder of(int height, int width) {
        return new Ladder(height, width);
    }

    private Ladder(int height, int width) {
        for (int i = 0; i < height; i++) {
            ladder.add(new Lines(width));
        }
    }

    public List<Lines> showLadder() {
        return ladder;
    }

    public UserResult playLadderGame(Users users, String inputName) {
        int userPosition = users.findUserPosition(inputName);
        for (int i = 0; i < ladder.size(); i++) {
            userPosition = ladder.get(i).move(userPosition);
        }
        return new UserResult(inputName, userPosition);
    }

    public List<UserResult> playLadderGames(Users users) {
        List<UserResult> userResults = new ArrayList<>();
        for (User user : users.showUsers()) {
            userResults.add(playLadderGame(users, user.userName()));
        }
        return userResults;
    }
}
