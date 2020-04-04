package ladder.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
    }

    @DisplayName("참여자 한명의 이름을 입력받는다.")
    @Test
    void inputPlayerNames() {
        String expect = "pobi";
        inputView = new InputView();

        String actual = inputView.inputPlayerName();

        assertThat(actual).isEqualTo(expect);
    }
}