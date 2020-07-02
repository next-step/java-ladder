package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {
    
    @DisplayName("연속으로 가로선이 겹칠 경우 예외 발생")
    @Test
    void validateDirectionTest(){
        // then
        assertThatThrownBy(() -> new Point(true, true)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("왼쪽으로 이동 시 -1 이동")
    @ParameterizedTest
    @CsvSource(value = {"true,false,-1", "false,true,1", "false,false,0"})
    void moveTest(boolean left, boolean right, int expected){
        // given
        Point point = new Point(left, right);

        // when
        int result = point.move();

        // then
        assertThat(result).isEqualTo(expected);
    }


}
