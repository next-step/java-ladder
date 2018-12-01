package ladder.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void 생성() {
        assertThat(Line.from(5)).isNotNull();
    }

    @Test
    public void 생성_참가자_수_5명_일때_포인트_4개() {
        assertThat(Line.from(5).getPoints().size()).isEqualTo(4);
    }
}