package ladder.domain.dto;

import ladder.domain.player.Player;
import ladder.domain.prize.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderMatchResultTest {

    private Map<Player, Prize> matchResult;

    @BeforeEach
    void setUp() {
        this.matchResult = new LinkedHashMap<>();
        matchResult.put(Player.of("pobi"), Prize.of("3000"));
        matchResult.put(Player.of("honux"), Prize.of("꽝"));
    }

    @DisplayName("게임 결과가 null 이면 예외를 반환")
    @ParameterizedTest
    @NullSource
    void createFailure(final Map<Player, Prize> matchResult) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderMatchResult.of(matchResult));
    }

    @DisplayName("게임 참여자 리스트를 반환")
    @Test
    void getPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(Player.of("pobi"));
        players.add(Player.of("honux"));

        assertThat(LadderMatchResult.of(matchResult).getPlayers())
                .isEqualTo(players);
    }

    @DisplayName("참여자의 이름에 해당하는 참여자의 게임 결과값을 반환")
    @ParameterizedTest
    @MethodSource
    void match(final String playerName, final Prize expected) {
        assertThat(LadderMatchResult.of(matchResult).match(playerName))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> match() {
        return Stream.of(
                Arguments.of("pobi", Prize.of("3000")),
                Arguments.of("honux", Prize.of("꽝"))
        );
    }

    @DisplayName("결과를 알고자 하는 참여자의 이름이 참여자에 포함되지 않은 경우 예외를 반환")
    @Test
    void matchFailure() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderMatchResult.of(matchResult)
                        .match("heejeong"));
    }
}
