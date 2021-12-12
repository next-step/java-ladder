package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {

    @Test
    @DisplayName("왼쪽 이동시 값은 0, 오른쪽 이동시 값은 2 가 나온다.")
    public void move(){
        Assertions.assertAll(
                () -> assertThat(Position.move(1, Arrays.asList(1,0,0)).value()).isEqualTo(0),
                () -> assertThat(Position.move(1, Arrays.asList(0,1,0)).value()).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("왼쪽 이동 줄 이 있으면 1이 발생")
    public void left(){
        int position = Position.left(1, Arrays.asList(1,0,0));
        assertThat(position).isEqualTo(1);
    }

    @Test
    @DisplayName("오른쪽 이동 줄 이 있으면 1이 발생")
    public void right(){
        int position = Position.right(1, Arrays.asList(0,1,0));
        assertThat(position).isEqualTo(1);
    }
}
