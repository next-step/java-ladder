package domain.ladder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderManageTest {

    @Test
    public void 플레이어_라인_생성여부() {
        String[] names = new String[]{"pobi", "honux"};

        List<Line> line = new ArrayList<>();
        line.add(new Line(Arrays.asList(true, false, true)));
        line.add(new Line(Arrays.asList(true, false, false)));

        LadderManage ladderManage = new LadderManage(names, line);
        assertThat(ladderManage.getLines().getLine()).hasSize(2);
        assertThat(ladderManage.getPlayers()).hasSize(2);

    }
}