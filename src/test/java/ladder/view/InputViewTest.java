package ladder.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    private InputView inputView;

    @DisplayName("참여자 한명의 이름을 입력받는다.")
    @Test
    void inputPlayerNames() {
        String expect = "pobi";
        inputView = new InputView(createInputStream(expect));

        String actual = inputView.inputPlayerName();

        assertThat(actual).isEqualTo(expect);
    }

    ByteArrayInputStream createInputStream(String name) {
        return new ByteArrayInputStream(name.getBytes());
    }
}