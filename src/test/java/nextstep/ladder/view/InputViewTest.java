package nextstep.ladder.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @Test
    void splitNames() {
        assertThat(InputView.splitName("white,blue,green,red")).containsExactly("white", "blue", "green", "red");
    }
}
