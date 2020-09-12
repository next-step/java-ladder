package step04.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderUsersTest {

    @DisplayName("인자로 받은 크기와 유저 수 가 같은지 검증")
    @ParameterizedTest
    @MethodSource("provideSizeAndResult")
    void isEqualSize(int size, boolean expected) {
        // given
        LadderUsers ladderUsers = new LadderUsers(makeMockUsers());

        // when & then
        assertThat(ladderUsers.isEqualSize(size)).isEqualTo(expected);
    }

    private List<LadderUser> makeMockUsers() {
        return Arrays.asList(
                new LadderUser("test1"),
                new LadderUser("test2"),
                new LadderUser("test3")
        );
    }

    private static Stream<Arguments> provideSizeAndResult() {
        return Stream.of(
                Arguments.of(3, true),
                Arguments.of(2, false),
                Arguments.of(5, false)
        );
    }

    @DisplayName("인덱스번호에 해당하는 유저를 반환하는 로직 검증")
    @ParameterizedTest
    @MethodSource("provideIndexAndResult")
    void getUserByIndex(int index, LadderUser expected) {
        // given
        LadderUsers ladderUsers = new LadderUsers(makeMockUsers());

        // when & then
        assertThat(ladderUsers.getUserByIndex(index)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideIndexAndResult() {
        return Stream.of(
                Arguments.of(0, new LadderUser("test1")),
                Arguments.of(1, new LadderUser("test2")),
                Arguments.of(2, new LadderUser("test3"))
        );
    }

    @DisplayName("유저 수를 반환하는 로직 검증")
    @Test
    void getUserNumber() {
        // given
        LadderUsers ladderUsers = new LadderUsers(makeMockUsers());

        // when & then
        assertThat(ladderUsers.getUserNumber()).isEqualTo(3);
    }
}
