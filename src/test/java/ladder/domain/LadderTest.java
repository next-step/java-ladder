package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void 사다리를_생성할_수_있다() {
        //given

        //when
        Ladder ladder = Ladder.create(Width.create(6), Height.create(6));
        //then
        assertThat(ladder).isEqualTo(Ladder.create(Width.create(6), Height.create(6)));
    }

}
