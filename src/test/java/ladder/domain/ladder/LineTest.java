package ladder.domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("참가 인원과 사다리의 Point의 수가 같은지 테스트")
    public void LinePointNumTest() {
        Assertions.assertThat(new Line(5).getPoints().size()).isEqualTo(5);

        Assertions.assertThat(new Line(12345).getPoints().size()).isEqualTo(12345);
    }
}
