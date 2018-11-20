package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void 생성() {
        Line line = Line.create(5);
        assertThat(line).isNotNull();
        assertThat(line.size()).isEqualTo(5);
    }
}
