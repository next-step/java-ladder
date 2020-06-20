package ladder.domain.user;

import ladder.domain.user.LadderUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LadderUsersTest {
    @ParameterizedTest
    @MethodSource("userListByOnePerson")
    @NullAndEmptySource
    @DisplayName("사다리 참여자 생성 시 User의 List는 두명 이상이어야 한다.")
    void validate_user_list(List<String> names) {
        assertThatThrownBy(() -> LadderUsers.of(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 게임의 참여자는 " + LadderUsers.MIN_USER_SIZE + "명 이상이어야 합니다.");
    }

    static Stream<Arguments> userListByOnePerson() {
        return Stream.of(arguments(Arrays.asList("pobi")));
    }

    @ParameterizedTest
    @MethodSource("userListByTwoMorePerson")
    @DisplayName("사다리 참여자 생성 시 User의 List는 두명 이상인 경우 정상 생성된다.")
    void create_ladder_users(List<String> names) {
        assertThat(LadderUsers.of(names)).isNotNull();
    }

    static Stream<Arguments> userListByTwoMorePerson() {
        return Stream.of(arguments(Arrays.asList("pobi", "honux")));
    }
}