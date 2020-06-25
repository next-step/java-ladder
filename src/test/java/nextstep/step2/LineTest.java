package nextstep.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    Line line;

    @BeforeEach
    void setUp() {
        line = Line.of(true);
    }

    @DisplayName("Line의 정적 템플릿 메서드 생성")
    @Test
    void of() {
        assertThat(line.isLine()).isTrue();
    }

    @DisplayName("이전 line이 true 값이면 다음 line의 값을 false 확인")
    @Test
    void falseIfPreviousLineIsTrue() {
        Line next = line.next();
        assertThat(next).isEqualTo(Line.of(false));
    }
}
