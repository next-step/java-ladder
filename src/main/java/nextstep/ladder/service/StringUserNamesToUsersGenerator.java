package nextstep.ladder.service;

import nextstep.ladder.domain.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUserNamesToUsersGenerator {

    private static final String REGEX = ",";

    public static List<User> toUsers(String names) {
        return Stream.of(names.split(REGEX))
                .map(User::new)
                .collect(Collectors.toList());
    }
}
