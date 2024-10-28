package ladder.domain;

import ladder.exception.InvalidHeightOfLadderException;
import ladder.exception.InvalidNumberOfPlayersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @DisplayName("사다리 최대 높이와 플레이서 수를 입력하면 사다리를 생성할 수 있다.")
    @Test
    void createLadderTest() {
        int heightOfLadder = 5;
        int numberOfPlayers = 4;
        Ladder ladder = new Ladder(heightOfLadder, numberOfPlayers);

        assertThat(ladder.lines()).hasSize(heightOfLadder);
    }

    @DisplayName("1 미만의 사다리 높이를 입력하면 예외가 발생한다.")
    @Test
    void invalidHeightOfLadderExceptionTest() {
        int heightOfLadder = 5;
        int numberOfPlayers = 0;

        assertThatThrownBy(() -> new Ladder(heightOfLadder, numberOfPlayers))
                .isInstanceOf(InvalidNumberOfPlayersException.class)
                .hasMessage("플레이어 수는 1명 이상입니다.");
    }

    @DisplayName("1 미만의 플레이어 수를 입력하면 예외가 발생한다.")
    @Test
    void invalidNumberOfPlayersExceptionTest() {
        int heightOfLadder = 0;
        int numberOfPlayers = 4;

        assertThatThrownBy(() -> new Ladder(heightOfLadder, numberOfPlayers))
                .isInstanceOf(InvalidHeightOfLadderException.class)
                .hasMessage("사다리 높이는 1 이상이어야 합니다.");
    }


}