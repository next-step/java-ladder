package nextstep.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NamesTest {
    @Test
    @DisplayName("중복된 이름 불가능")
    public void validate() {
        Assertions.assertThatThrownBy(
            () -> new Names("pobi, pobi")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
