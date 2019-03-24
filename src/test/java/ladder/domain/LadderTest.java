package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LadderTest {

    @Test
    public void 원하는_만큼_높이생성() {
        Ladder ladder = new Ladder();

        assertThat(ladder.generate(3, 5)).isEqualTo(3);
    }
}
