package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ResultTest {

    @Test
    @DisplayName("정적 팩토리 메소드 테스트")
    void from() {
        Result actual = Result.from("test");

        assertThat(actual).isEqualTo(new Result("test"));
    }
}