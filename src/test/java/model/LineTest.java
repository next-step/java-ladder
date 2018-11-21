package model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private Line line;
    private int countOfPerson;

    @Before
    public void setUp() throws Exception {
        countOfPerson = 4;
        line = Line.of(countOfPerson);

    }

    @Test
    public void hasPoint_선있을때(){
        line.addLine(Positive.of(1));
        assertThat(line.hasLine(1)).isTrue();
    }

    @Test
    public void hasPoint_마지막인덱스(){
        assertThat(line.hasLine(4)).isFalse();
    }

    @Test ( expected = IllegalStateException.class)
    public void addPoint_최대높이초과() {
        for (int i = 0; i < countOfPerson +1; i++) {
            line.addPoint(Direction.STRAIGHT);
        }
    }


}
