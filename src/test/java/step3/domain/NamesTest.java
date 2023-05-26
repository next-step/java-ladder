package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Names;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NamesTest {

    @DisplayName("사람은 적어도 2명 이상이어야 한다.")
    @Test
    public void namesSizeTest() {
        assertThatThrownBy(() -> new Names(List.of("테스트")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
