package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PersonTest {

    @Test
    @DisplayName("5명 이상 생성 불가")
    void constructor() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Person("kimjooho"));
    }
}