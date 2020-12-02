package domain;

import ladder.domain.Line;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void 알맞은_인원수에_맞게_라인이_생성되는지(){
        Line lineTest = new Line(5);
        assertThat(4).isEqualTo(lineTest.getPoints().size());
    }
}
