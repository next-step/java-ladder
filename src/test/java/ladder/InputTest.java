package ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.view.InputView.validateNames;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputTest {

    @Test
    void 이름이_5자이상이면_에러발생() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    validateNames(List.of("일이삼사오육"));
                });
    }
}
