package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinesTest {

    @Test
    void createTest() {
        Lines lines = new Lines(List.of("123", "1234"), 2);

        assertThat(lines.getLineNames()).containsExactly("123","1234");
    }

    @DisplayName("필수 기본 연결을 확인한다.")
    @Test
    void connectMinimumTest() {
        Lines lines = new Lines(List.of("123", "1234", "12345", "12"), 2);

        assertThat(lines.isAllLineConnected()).isFalse();

        lines.connectMinimum();

        System.out.println(lines);

        assertThat(lines.isAllLineConnected()).isTrue();
    }

}