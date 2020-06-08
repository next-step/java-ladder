package ladder.domain.dto;

import ladder.domain.player.Player;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.LinkedHashMap;
import java.util.Map;

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
}
