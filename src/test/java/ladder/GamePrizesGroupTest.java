package ladder;

import ladder.domain.GamePrizesGroup;
import ladder.domain.LadderBuildingException;
import ladder.domain.PlayersGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GamePrizesGroupTest {

    @DisplayName("객체 정상 생성 테스트")
    @Test
    public void makeGamePrizesGroup_정상() {
        List<String> playerNames = Arrays.asList("aa", "bb");
        PlayersGroup playersGroup = PlayersGroup.of(playerNames);
        List<String> gamePrizeNames = Arrays.asList("꽝", "4444");

        assertThatCode(() -> {
            GamePrizesGroup.of(gamePrizeNames, playersGroup);
        }).doesNotThrowAnyException();
    }

    @DisplayName("객체 생성 실패 테스트(참가자 수와 실행 결과의 개수가 다를 때)")
    @Test
    public void makeGamePrizesGroup_예외() {
        List<String> playerNames = Arrays.asList("aa", "bb", "cc", "dd");
        PlayersGroup playersGroup = PlayersGroup.of(playerNames);
        List<String> gamePrizeNames = Arrays.asList("꽝", "4444");

        assertThatThrownBy(() -> {
            GamePrizesGroup.of(gamePrizeNames, playersGroup);
        }).isInstanceOf(LadderBuildingException.class)
                .hasMessageContaining(LadderBuildingException.INVALID_GAME_PRIZE_COUNTS);
    }
}
