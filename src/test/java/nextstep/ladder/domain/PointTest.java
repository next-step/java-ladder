package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PointTest {

    PointCreationRule pointCreationRule;

    @BeforeEach
    void before(){
        pointCreationRule = new RandomPointCreationRule();
    }

    @Test
    public void first() {
        assertThat(Point.first(true).move()).isEqualTo(1);
        assertThat(Point.first(false).move()).isEqualTo(0);
    }

    @Test
    public void next_stay() {
        Point second = Point.first(false).next(false);
        assertThat(second.move()).isEqualTo(1);
    }

    @Test
    public void next_left() {
        Point second = Point.first(true).next(false);
        assertThat(second.move()).isEqualTo(0);
     }

    @Test
    public void 테스트() {
        Point second = Point.first(true).next(true);
        assertThat(second.move()).isEqualTo(0);
    }

    @Test
    public void next_right() {
        Point second = Point.first(false).next(true);
        assertThat(second.move()).isEqualTo(2);
    }

}