package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {

    @DisplayName("높이가 1보다 작을 경우 예외가 발생한다.")
    @Test
    void test01() {
        assertThatThrownBy(() -> new Height(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("높이는 1보다 커야합니다.");
    }

    @DisplayName("높이가 1 이상인 Height 객체를 생성할 수 있다.")
    @Test
    void test02() {
        Height height = new Height(1);
        assertThat(height.getHeight()).isEqualTo(1);
    }
}
