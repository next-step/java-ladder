package nextstep.laddergame.view;

import nextstep.laddergame.domain.LadderHeights;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputViewTest {

    @DisplayName("참여자 이름은 쉼표를 기준으로 입력된다.")
    @Test
    public void playerNamesInputTest() {
        List<String> names = Arrays.asList("abc", "def", "ghi", "jkl");
        InputView inputView = createMockInputView(String.join(",", names));
        List<String> playerNames = inputView.getListInputs();
        assertThat(playerNames)
                .hasSize(4)
                .containsAll(names);
    }

    @DisplayName("사다리의 높이가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    public void invalidLadderHeightsInputTest() {
        InputView inputView = createMockInputView("a");
        assertThatIllegalArgumentException()
                .isThrownBy(inputView::getLadderHeights)
                .withMessageContaining("a");
    }

    @DisplayName("사다리의 높이를 입력 받을 수 있다.")
    @Test
    public void inputLadderHeightsTest() {
        InputView inputView = createMockInputView("5");
        assertThat(inputView.getLadderHeights())
                .isEqualTo(LadderHeights.of(5));
    }

    private InputView createMockInputView(String input) {
        return InputView.of(new ByteArrayInputStream(input.getBytes()));
    }
}