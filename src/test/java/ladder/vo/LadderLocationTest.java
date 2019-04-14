package ladder.vo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderLocationTest {
    @Test
    public void 사다리_위치의_index가_0_미만일_경우_IllegalArgumentException() {
        // given
        int index = -1;
        int floor = 0;

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderLocation(index, floor));
    }

    @Test
    public void 사다리_위치의_floor가_0_미만일_경우_IllegalArgumentException() {
        // given
        int index = 0;
        int floor = -1;

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderLocation(index, floor));
    }

    @Test
    public void 사다리_위치가_바닥인지_확인() {
        // given
        LadderLocation bottom = new LadderLocation(0, 0);
        LadderLocation notBottom = new LadderLocation(0, 1);

        // when
        boolean shouldBeTrue = bottom.isBottom();
        boolean shouldBeFalse = notBottom.isBottom();

        // then
        assertThat(shouldBeTrue).isTrue();
        assertThat(shouldBeFalse).isFalse();
    }
}
