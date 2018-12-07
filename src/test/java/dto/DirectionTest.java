package dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    public void getNowDirection() {
        assertThat(Direction.find(false,false)).isEqualTo(Direction.BOTTOM);
        assertThat(Direction.find(false,true)).isEqualTo(Direction.RIGHT);
        assertThat(Direction.find(true,false)).isEqualTo(Direction.LEFT);
        assertThat(Direction.find(true,true)).isEqualTo(Direction.ERROR);
    }

    @Test
    public void getFirts() {
        assertThat(Direction.next(false,Difficulty.NORMAL)).isNotEqualByComparingTo(Direction.LEFT);
    }

    @Test
    public void getLast() {
        assertThat(Direction.next(true,Difficulty.NORMAL)).isNotEqualByComparingTo(Direction.RIGHT);
    }
}
