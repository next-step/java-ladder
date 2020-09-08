package nextstep.ladder.domain;

import java.util.*;

public class LadderResultBoard {

    private final List<User> resultPosition = new ArrayList<>();

    public LadderResultBoard() {
    }

    public static LadderResultBoard create() {
        return new LadderResultBoard();
    }

    public void addUserLastLadderPosition(User user) {
        resultPosition.add(user);
    }

    public List<User> users() {
        return Collections.unmodifiableList(resultPosition);
    }

}
