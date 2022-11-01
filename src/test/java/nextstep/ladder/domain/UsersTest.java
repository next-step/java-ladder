package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class UsersTest {

    @ParameterizedTest
    @MethodSource("usersTestSource")
    void find_user_index_by_name_test(Users users, String name, int expectIndex) {
        assertThat(users.indexOfUser(name)).isEqualTo(expectIndex);
    }

    @ParameterizedTest
    @ValueSource(strings = { "e", "f" })
    void find_user_index_by_name_exception_test(String name) {
        Users users = new Users(generateUser());
        assertThatThrownBy(() -> users.indexOfUser(name)).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> usersTestSource() {
        return Stream.of(
                arguments(new Users(generateUser()), "a", 0),
                arguments(new Users(generateUser()), "b", 1),
                arguments(new Users(generateUser()), "c", 2)
        );
    }

    static List<String> generateUser() {
        return Lists.list("a", "b", "c");
    }
}
