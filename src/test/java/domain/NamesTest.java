package domain;

import ladder.domain.Names;
import ladder.util.ErrorMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NamesTest {

    private static Names namesTest;

    @Test
    void 이름_empty_테스트() {
        assertThatThrownBy(() ->
                namesTest = new Names(",,")
        ).isInstanceOf(RuntimeException.class)
                .withFailMessage(ErrorMessage.getCheckInputNames());
    }

    @Test
    void 이름_길이_테스트() {
        assertThatThrownBy(() ->
                namesTest = new Names("123123123")
        ).isInstanceOf(RuntimeException.class)
                .withFailMessage(ErrorMessage.getCheckInputNames());
    }
}
