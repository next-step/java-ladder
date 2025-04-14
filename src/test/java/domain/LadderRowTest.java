package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LadderRowTest {

    @Test
    @DisplayName("사다리 행의 열은 전체 너비 - 1 만큼 생성된다.")
    void createColumns() {
        LadderRow ladderRow = new LadderRow(5, () -> true);
        assertThat(ladderRow.getColumns()).hasSize(4);
    }

    @Test
    @DisplayName("사다리에서 연결된 다음 열은 연결되지 않는다.")
    void adjacentConnectionsDoNotOverlap() {
        LadderRow ladderRow = new LadderRow(5, () -> true);
        List<Boolean> columns = ladderRow.getColumns();
        
        assertThat(columns).containsExactly(true, false, true, false);
    }
}
