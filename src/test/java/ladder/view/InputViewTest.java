package ladder.view;

import ladder.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    private InputView inputView;

    @DisplayName("참여자 이름을 입력받는다.")
    @Test
    void inputPlayerName() {
        String name = "pobi";
        inputView = new InputView(createInputStream(name));
        Player expect = new Player(name);

        Player actual = inputView.inputPlayerName();

        assertThat(actual).isEqualTo(expect);
    }

    ByteArrayInputStream createInputStream(String name) {
        return new ByteArrayInputStream(name.getBytes());
    }
}