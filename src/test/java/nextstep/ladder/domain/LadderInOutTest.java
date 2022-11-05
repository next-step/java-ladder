package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderInOutTest {

    @DisplayName("사용자와 결과의 길이가 동일하지 않으면 exception")
    @ParameterizedTest
    @MethodSource("usersTestSource")
    void user_result_length_test(Users user, List<String> result) {
        assertThatThrownBy(() -> new LadderInOut(result, user))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과와 사용자 수는 동일해야 합니다.");
    }

    @DisplayName("사용자와 결과의 길이가 동일")
    @Test
    void user_result_length_equal_test() {
        assertDoesNotThrow(
                () -> new LadderInOut(Lists.list("1", "2", "3"), new Users(Lists.list("a", "b", "c"))));
    }

    static Stream<Arguments> usersTestSource() {
        return Stream.of(
                arguments(new Users(Lists.list("a", "b", "c")), Lists.list("1", "2")),
                arguments(new Users(Lists.list("a", "b", "c")), Lists.list("1")),
                arguments(new Users(Lists.list("a", "b", "c")), Lists.list("1", "2", "3", "4"))
        );
    }
}
