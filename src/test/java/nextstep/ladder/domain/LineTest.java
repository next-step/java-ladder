package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("참가자수(n)에 따라 Line의 사이즈는 (n - 1)이 된다")
    @Test
    void initLine() {
        assertThat(new Line(3, () -> true).size()).isEqualTo(2);
    }

    @DisplayName("점들이 각각 true인지 false인지 검증한다")
    @Test
    void validateLine() {
        Line line = new Line(3, () -> true);

        List<Boolean> booleans = line.validateLine();

        Assertions.assertThat(booleans.get(0)).isTrue();

        // 이전 index의 boolean이 true면 항상 false가 된다
        Assertions.assertThat(booleans.get(1)).isFalse();
    }
}
