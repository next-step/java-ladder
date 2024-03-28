package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("각 Line 은 높이와 사용자(owner) 를 가진다.")
    @Test
    void test01() {
        Line line = new Line(new Name("pobi"), 5);
        assertThat(line).isNotNull();
    }

    @DisplayName("Line 객체는 특정 높이에 bridge 를 추가할 수 있다.")
    @Test
    void test02() {
        Line line = new Line(new Name("pobi"), 5);
        line.addBridge(0);
        assertThat(line.hasBridge(0)).isTrue();
    }
}
