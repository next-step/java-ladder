package ladder.model.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayersTest {

    @Test
    @DisplayName("참가하는 사람이 2명 미만일 경우 예외 발생")
    void minPlayerCountExceptionTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Players("play1"))
                .withMessage("게임을 하려면 최소 2명이 필요합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3|3", "1,2,3,4|4", "1,2,3,4,5|5"}, delimiter = '|')
    @DisplayName("입력받은 값에 따라 생성된 Player 개수 확인")
    void playerCountTest(String players, int size) {
        assertThat(new Players(players).count()).isEqualTo(size);
    }

    @ParameterizedTest
    @CsvSource(value = {"1|0", "2|1", "3|2", "4|3"}, delimiter = '|')
    @DisplayName("players 에서 해당 player의 인덱스 가져오는 것 테스트")
    void indexOfTest(String name, int index) {
        Players players = new Players("1,2,3,4");
        assertThat(players.indexOf(new Player(name))).isEqualTo(index);
    }

    @ParameterizedTest
    @CsvSource(value = {"1|1", "2|1", "3|1", "all|4"}, delimiter = '|')
    @DisplayName("resultOf 값에 따라 가져오는 player list 사이즈 테스트")
    void resultOfTest(String name, int expected) {
        Players players = new Players("1,2,3,4");
        assertThat(players.getResultOf(name).size()).isEqualTo(expected);
    }
    
    @ParameterizedTest
    @CsvSource(value = {"1|true", "3|true", "5|false", "6|false"}, delimiter = '|')
    @DisplayName("players 에서 해당 player의 인덱스 가져오는 것 테스트")
    void containsTest(String name, boolean expected) {
        Players players = new Players("1,2,3,4");
        assertThat(players.contains(name)).isEqualTo(expected);
    }
}
