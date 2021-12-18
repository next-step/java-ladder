package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResultTest {
    @Test
    void 생성_비교() {
        Result result = new Result("꽝");
        assertThat(result.getResult()).isEqualTo("꽝");
    }

    @Test
    void 결과_미입력() {
        assertThatThrownBy(() -> {
            new Member("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
