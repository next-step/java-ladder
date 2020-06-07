package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("라인 생성 테스트")
    void create(){
        Line line = new Line(false);
        assertThat(line).isEqualTo(new Line(false));
    }
}
