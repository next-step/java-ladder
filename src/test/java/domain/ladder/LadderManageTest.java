package domain.ladder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderManageTest {

    @Test
    public void 플레이어_라인_생성여부() {
        String[] names = new String[]{"pobi", "honux"};

        LadderManage ladderManage = new LadderManage(names, 5);
        assertThat(ladderManage.getLines()).hasSize(5);
        assertThat(ladderManage.getPlayers()).hasSize(2);

    }
}