package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @DisplayName("이름 생성 시 에러 발생")
    @Test
    void create_with_invalid_input() {
         assertThatThrownBy(() -> new Name("computer"))
                 .isInstanceOf(IllegalArgumentException.class);

    }
}
