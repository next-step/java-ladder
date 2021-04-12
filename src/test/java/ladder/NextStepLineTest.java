package ladder;

import ladder.domain.nextstep.NextStepLine;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NextStepLineTest {
    @Test
    public void Line_Point_수_Test(){
        NextStepLine line = new NextStepLine(10);
        assertThat(line.points().size()).isEqualTo(10);
    }
}
