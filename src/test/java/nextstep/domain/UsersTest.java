package nextstep.domain;

import org.junit.jupiter.api.Test;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UsersTest {
    @Test
    void 유저_수_2명_미만() {
        assertThatThrownBy(() -> {
            new Users(IntStream.range(0, 1)
                    .mapToObj(i -> new User("test"))
                    .collect(Collectors.toList()));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}