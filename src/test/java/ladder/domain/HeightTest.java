package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Height 클래스 추가")
class HeightTest {

    @DisplayName("1 이상의 Height 객체를 생성할 수 있다.")
    @Test
    void create() {
        int count = 1;
        Height height = new Height(count);

        assertThat(height.getHeight()).isEqualTo(count);
    }
}
