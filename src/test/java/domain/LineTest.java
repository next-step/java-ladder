package domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {
    private Line line;

    @Before
    public void line_생성() {
        this.line = new Line(3);
    }

    @Test
    public void setLeftTest() {
        assertThat(this.line.isRight(Point.next(true))).isFalse();
    }

    @Test
    public void locationTest() {
        System.out.println(this.line.location(this.line, 2));
    }
}
