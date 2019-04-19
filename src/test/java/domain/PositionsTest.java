package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionsTest {
    @Test(expected = IllegalArgumentException.class)
    public void 이름이_한글자_미만일_경우_예외가_발생한다() {
        new Positions(Arrays.asList(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 이름이_다섯글자를_초과할_경우_예외가_발생한다() {
        new Positions(Arrays.asList("123456"));
    }

    @Test
    public void 이름으로_위치를_찾는다() {
        Positions positions = new Positions(Arrays.asList("1번유저","2번유저","3번유저"));

        assertThat(positions.findByName("2번유저")).isEqualTo(2);
    }

    @Test
    public void 위치로_이름을_찾는다() {
        Positions positions = new Positions(Arrays.asList("1번유저","2번유저","3번유저"));

        assertThat(positions.findByLocation(2)).isEqualTo("2번유저");
    }
}
