package ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.dto.PlayerName.validateName;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest {

    @Test
    void 이름이_5자이상이면_에러발생() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    validateName("일이삼사오육");
                });
    }
}
