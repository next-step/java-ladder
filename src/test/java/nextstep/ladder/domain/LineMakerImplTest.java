package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineMakerImplTest {
    @Test
    @DisplayName("사다리 6개 램덤라인 한 줄을 생성한다")
    void makeLine() {
        LineMaker lineMaker = new LineMaker(6);
        assertThat(lineMaker.makeLine().getPoints()).hasSize(6);
    }
}
