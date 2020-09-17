package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void pointTest(){
        Point point = new Point(0,true);
        assertThat(point.next().getIndex()).isEqualTo(1);
        assertThat(point.next().next().getIndex()).isEqualTo(2);
    }
}
