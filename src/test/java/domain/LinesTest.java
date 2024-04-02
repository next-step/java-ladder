package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @DisplayName("갯수와 높이를 기반으로 Lines 객체를 생성한다.")
    @Test
    void test01() {
        Lines lines = Lines.of(4, 5);
        assertThat(lines).isNotNull();
    }
}
