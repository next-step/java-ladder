package step2.domain;

import java.util.*;

public class User {

    private final String name;

    private static class UserCache {
        private static final Map<String, User> USER_CACHE = new HashMap<>();

        private static User search(String name) {
            return Optional.ofNullable(USER_CACHE.get(name))
                    .orElseGet(() -> cache(name));
        }

        private static User cache(String name) {
            User user = User.valueOf(name);
            USER_CACHE.put(name, user);
            return user;
        }
    }

    private User(String name) {
        this.name = name;
    }

    public static User valueOf(String name) {
        validUserCreate(name);
        return UserCache.search(name);
    }

    private static void validUserCreate(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("사다리 게임 참여자 이름은 필수값 입니다.");
        }

        if (5 < name.length()) {
            throw new IllegalArgumentException("사다리 게임 참여자 이름은 최대 5글자까지 부여할 수 있습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
