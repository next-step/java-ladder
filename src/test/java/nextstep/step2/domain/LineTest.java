package nextstep.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.step2.domain.Line;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("한 라인 생성")
    void create() {
        assertThat(Line.create(5).getPoints().size()).isEqualTo(5);
    }
}
