package nextstep.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UsersTest {
    @Test
    void 유저_수_2명_미만() {
        assertThatThrownBy(() -> {
            new Users(IntStream.range(0, 1)
                    .mapToObj(i -> new User("test"))
                    .collect(Collectors.toList()));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저들_동일이름_존재() {
        assertThatThrownBy(() -> {
            new Users(IntStream.range(0, 3)
                    .mapToObj(i -> new User("test"))
                    .collect(Collectors.toList()));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저조회시_존재하지_않을때() {
        assertThat(new Users(Arrays.asList(new User("a"), new User("b"), new User("c")))
                .findUsernameIndex("d")).isEqualTo(-1);
    }

}