package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @DisplayName("index 테스트")
    @Test
    void pointTest(){
        Point point = new Point(0,false,true);
        assertThat(point.next().getIndex()).isEqualTo(1);
        assertThat(point.next().next().getIndex()).isEqualTo(2);
    }

    @DisplayName("right & left 테스트")
    @Test
    void isRight_Test(){
        Point point = new Point(0,false,true);
        assertThat(point.isRight()).isEqualTo(true);
        assertThat(point.isLeft()).isEqualTo(false);
    }
}
