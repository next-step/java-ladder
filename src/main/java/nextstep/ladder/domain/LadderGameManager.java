package nextstep.ladder.domain;

import nextstep.ladder.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static nextstep.ladder.constant.ExceptionMessage.INVALID_JOIN_USERS_MINIMIM_SIZE;

public class LadderGameManager {

    private List<User> users = new ArrayList<>();

    private int ladderHeight;

    private int MINIMUM_JOIN_USERS = 2;

    private LadderGameManager(String[] users, int ladderHeight) {
        genaratorUser(users);
        this.ladderHeight = ladderHeight;

        if (users.length < MINIMUM_JOIN_USERS) {
            throw new IllegalArgumentException(INVALID_JOIN_USERS_MINIMIM_SIZE);
        }
    }

    public static LadderGameManager create(String users, int ladderHeight) {
        String[] splitUsers = StringUtils.splitUsers(users);

        return new LadderGameManager(splitUsers, ladderHeight);
    }

    private void genaratorUser(String[] users) {
        for (String user : users) {
            this.users.add(User.join(user));
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
