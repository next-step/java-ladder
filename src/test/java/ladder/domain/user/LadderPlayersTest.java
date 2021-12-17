package ladder.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LadderPlayersTest {

    @ParameterizedTest
    @DisplayName("Players 객체 생성 - 입력된 플레이어 이름 수 만큼 Player 객체로 저장")
    @MethodSource("providePlayers")
    void create(List<String> users, int size) {
        LadderPlayers players = new LadderPlayers(users);
        assertThat(players.getPlayers()).size().isEqualTo(size);
    }

    private static Stream<Arguments> providePlayers() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "honux", "crong"), 3),
                Arguments.of(Arrays.asList("pobi", "honux", "crong", "jk", "Q"), 5)
        );
    }

    @Test
    @DisplayName("Players 값이 비어있을 경우 예외 반환 -> IllegalArgumentException")
    void checkSize() {
        assertThatThrownBy(() -> new LadderPlayers(Collections.EMPTY_LIST))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("입력한 값이 Players에서 동일한 이름 객체 위치값 반환")
    @MethodSource("provideFindPlayers")
    void findPlayerIndex(String value, int expected) {
        LadderPlayers players = new LadderPlayers(Arrays.asList("pobi", "honux", "crong"));
        assertThat(players.findIndexByName(value)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideFindPlayers() {
        return Stream.of(
                Arguments.of("pobi", 0),
                Arguments.of("honux", 1),
                Arguments.of("crong", 2)
        );
    }

    @Test
    @DisplayName("플레이어들 이름 리스트로 반환")
    void getPlayerNames() {
        LadderPlayers players = new LadderPlayers(Arrays.asList("pobi", "honux", "crong"));
        assertThat(players.getPlayerNames()).containsExactly("pobi", "honux", "crong");
    }

}
