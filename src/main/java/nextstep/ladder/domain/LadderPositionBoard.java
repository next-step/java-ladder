package nextstep.ladder.domain;

import java.util.*;

import static nextstep.ladder.constant.ExceptionMessage.NOT_EXIST_USER_NAME;

public class LadderPositionBoard {

    private final Map<Integer,User> ladderPosition = new HashMap<>();

    public LadderPositionBoard(Users users) {

        for(User user : users.getUsers()){
            int position = user.getPosition();
            ladderPosition.put(position, user);
        }
    }

    public static LadderPositionBoard create(Users users) {
        return new LadderPositionBoard(users);
    }

    public void switchPosition(int point) {
        User rightUser = ladderPosition.get(point + 1);
        rightUser.left();
        User leftUser = ladderPosition.get(point);
        leftUser.right();

        ladderPosition.put(point + 1, leftUser);
        ladderPosition.put(point, rightUser);
    }

    public Collection<User> users() {
        return ladderPosition.values();

    }

    public User resultUserPosition(String userName) {
        System.out.println(userName);
        Optional<Integer> userKey = Optional.ofNullable(ladderPosition.keySet().stream()
                .filter(key -> ladderPosition.get(key).getUserName().equalsIgnoreCase(userName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_USER_NAME)));

        return ladderPosition.get(userKey.get());
    }
}
