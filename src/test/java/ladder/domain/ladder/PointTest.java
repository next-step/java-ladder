package ladder.domain.ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PointTest {

    @Test
    public void 양쪽으로_건너갈_수_있게_생성할_경우_IllegalArgumentException() {
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Point(Cross.CROSS, Cross.CROSS));
    }
}
