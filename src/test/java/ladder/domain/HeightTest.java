package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HeightTest {

    @DisplayName("높이 객체를 생성한다.")
    @Test
    void create() {
        int height = 1;
        Height expect = new Height(height);

        Height actual = new Height(height);

        assertThat(actual).isEqualTo(expect);
    }
}