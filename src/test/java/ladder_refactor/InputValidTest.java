package ladder_refactor;

import ladder_refactor.domain.Answers;
import ladder_refactor.domain.Height;
import ladder_refactor.domain.Player;
import ladder_refactor.domain.Players;
import ladder_refactor.exception.LadderInputException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidTest {

    @Test
    @DisplayName("플레이어 생성")
    public void createPlayers() {
        Players players = Players.of("p1, p2, p3, p4, p5");
        Assertions.assertThat(players.count()).isEqualTo(5);
    }

    @Test
    @DisplayName("플레이어 이름 5자 이하")
    public void validPlayerName() {
        Assertions.assertThatThrownBy(() -> new Player("다섯글자이상")).isInstanceOf(LadderInputException.class);
    }

    @Test
    @DisplayName("사다리 높이는 숫자여야한다")
    public void isHeightNumber() {
        Assertions.assertThatThrownBy(() -> Height.of("가짜숫자형식")).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("사다리 높이 1이상")
    public void min_height() {
        Assertions.assertThatThrownBy(() -> Height.of("0")).isInstanceOf(LadderInputException.class);
    }

    @Test
    @DisplayName("결과 입력시 개수 매칭")
    public void answer() {
        Assertions.assertThatThrownBy(() ->
                        Answers.of("p1, p2", Players.of("1, 2, 3"))
        ).isInstanceOf(LadderInputException.class);
    }
}
