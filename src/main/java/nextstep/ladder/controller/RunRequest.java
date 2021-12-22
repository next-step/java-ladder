package nextstep.ladder.controller;

import nextstep.ladder.model.User;
import nextstep.ladder.model.UserName;
import nextstep.ladder.model.Users;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class RunRequest {
    private static final int MIN_HEIGHT_SIZE = 1;

    private final List<String> userNames;
    private final int heightOfLadder;

    private RunRequest(List<String> userNames, int heightOfLadder) {
        this.userNames = userNames;
        this.heightOfLadder = heightOfLadder;
    }

    public static RunRequest of(List<String> userNames, int heightOfLadder) {
        validate(userNames, heightOfLadder);
        return new RunRequest(userNames, heightOfLadder);
    }

    public Users participatedUsers() {
        return Users.from(users());
    }

    public int getHeightOfLadder() {
        return heightOfLadder;
    }

    private static void validate(List<String> userNames, int heightOfLadder) {
        validateUserNames(userNames);
        validateHeightOfLadder(heightOfLadder);
    }

    private static void validateHeightOfLadder(int heightOfLadder) {
        if (heightOfLadder < MIN_HEIGHT_SIZE) {
            throw new IllegalArgumentException(String.format("사다리 사이즈(%d)는 %d이상이 필요합니다.", heightOfLadder, MIN_HEIGHT_SIZE));
        }
    }

    private static void validateUserNames(List<String> userNames) {
        if (Objects.isNull(userNames)) {
            throw new IllegalArgumentException("전달된 사용자 이름이 null입니다.");
        }
        if (userNames.isEmpty()) {
            throw new IllegalArgumentException("전달된 사용자 이름이 비어있습니다.");
        }
    }

    private List<User> users() {
        return userNames.stream()
                .map(name -> new User(new UserName(name)))
                .collect(Collectors.toList());
    }
}
