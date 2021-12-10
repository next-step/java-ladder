package ladder.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @ParameterizedTest
    @DisplayName("Plyaers 객체 생성 - 입력된 플레이어 이름 수 만큼 Player 객체로 저장")
    @MethodSource("providePlayers")
    void create(List<String> users, int size) {
        Players players = new Players(users);
        assertThat(players.getPlayers()).size().isEqualTo(size);
    }

    private static Stream<Arguments> providePlayers() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "honux", "crong"), 3),
                Arguments.of(Arrays.asList("pobi", "honux", "crong", "jk", "Q"), 5)
        );
    }

}
