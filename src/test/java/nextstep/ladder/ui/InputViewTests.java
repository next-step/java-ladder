package nextstep.ladder.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTests {
    @DisplayName("사다리 게임에 참여할 사람의 명단, 최대 사다리 높이를 입력받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        String playerList = "poppo, ita, saul";
        int maxLadderHeight = 5;
        InputView inputView = new InputView(playerList, maxLadderHeight);
        assertThat(inputView).isNotNull();
    }

    @DisplayName("최대 사다리 높이가 0 이하인 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = { -1, -3, 0 })
    void createValidationTest(int invalidLadderHeight) {
        String playerList = "poppo, ita, saul";
        assertThatThrownBy(() -> new InputView(playerList, invalidLadderHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
