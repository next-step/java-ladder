package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    public void checkable을_커스텀하여_사다리_Line을_만들_수_있다(){
        //given
        //when
        Ladder ladder = Ladder.create(Width.create(3), Height.create(3));
        //then
        List<Boolean> points = ladder.randomLinePoints(Width.create(3), () -> true);

        assertThat(points).containsExactly(true, false, true);
    }


}

