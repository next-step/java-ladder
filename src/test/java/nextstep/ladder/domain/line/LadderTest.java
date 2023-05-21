package nextstep.ladder.domain.line;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderTest {

    @Test
    public void Ladder_생성테스트() {
        //given
        LineGenerator lineGenerator = new TestLineGenerator();
        List<Boolean> line1 = new ArrayList<>(Arrays.asList(true, false, true));
        List<Boolean> line2 = new ArrayList<>(Arrays.asList(true, false, true));
        List<List<Boolean>> lineList = new ArrayList<>();
        lineList.add(line1);
        lineList.add(line2);

        //when
        Ladder ladder = new Ladder(lineGenerator, 2, 3);

        //then
        assertThat(ladder).isEqualTo(lineList);
    }

}