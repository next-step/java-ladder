package nextstep.ladder.domain;

import java.util.*;

public class LadderResultBoard {

    private final Map<User,Integer> resultPositionMap = new HashMap<>();
    public LadderResultBoard() {
    }

    public static LadderResultBoard create() {
        return new LadderResultBoard();
    }

    public void addUserLastLadderPosition(User user, int position) {
        resultPositionMap.put(user,position);
    }

    public Map<User,Integer> resultUsers() {
        return Collections.unmodifiableMap(resultPositionMap);
    }

}
