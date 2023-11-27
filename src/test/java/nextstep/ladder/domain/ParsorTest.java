package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParsorTest {
    @DisplayName("구분자로 문자열 분리")
    @Test
    void 문자열_분리() {
        Assertions.assertThat(Parsor.splitString("pobi, next, step"))
                .containsExactly("pobi", "next", "step");
    }
}