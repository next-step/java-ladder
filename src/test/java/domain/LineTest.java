package domain;


import org.junit.Test;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LineTest {

    @Test(expected = RuntimeException.class)
    public void Line생성자잘못() {
        List<Boolean> booleanList = Arrays.asList(true, false, true, true);
        Line line = Line.ofGroup(booleanList);
    }

    @Test
    public void Line생성자() {
        List<Boolean> booleanList = Arrays.asList(true, false, true, false);
        Line line = Line.ofGroup(booleanList);
        assertThat(line.toString()).isEqualTo("|-----|     |-----|     |");
    }

    @Test
    public void 다음위치테스트() {
        List<Boolean> booleanList = Arrays.asList(true, false, true);
        List<Line> lines = new ArrayList<>();
        List<Player> results = StringUtils.joinPlayer(StringUtils.splitDelemeter("꽝,30000,100,1000"));
        lines.add(Line.ofGroup(booleanList));
        int position = 3;
        for (Line line : lines) {
            position = line.nextPosition(position);
        }
        assertThat(results.get(position).toString().trim()).isEqualTo("100");
    }


}