package domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {
    private Line line;

    @Before
    public void 라인_생성() {
        this.line = new Line(3);
    }

    @Test
    public void true끼리_이을_수_없다() {
        assertThat(this.line.isLeft(PointTest.LEFT_MOVABLE_POINT)).isFalse();
    }
}
