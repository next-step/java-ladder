package domain;


import org.junit.Test;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {

    @Test
    public void 최종위치테스트() {
        List<Line> lines = new ArrayList<>();
        List<Boolean> booleanList = Arrays.asList(true);//|-----|
        lines.add(new Line(booleanList));

        Ladder ladder = new Ladder(lines);
        int startPosition = 1;
        assertThat(0).isEqualTo(ladder.getFinalPosition(startPosition));
    }
}