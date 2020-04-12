package nextstep.ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsersTest {
    public static final Users USERS = new Users(new ArrayList<>(
            Stream.of(new User("pobi"),
                      new User("honux"),
                      new User("crong"),
                      new User("jk")
            )
                  .collect(Collectors.toList())));
}
