package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("각 Line 은 높이와 사용자(owner) 를 가진다.")
    @Test
    void test() {
        Line line = new Line(new Name("pobi"), 5);
        assertThat(line).isNotNull();
    }
}
