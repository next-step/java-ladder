package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LadderRowTest {

    @Test
    @DisplayName("사다리 행의 열은 전체 너비 - 1 만큼 생성된다.")
    void createColumns() {
        LadderRow ladderRow = new LadderRow(5, () -> true);
        AtomicInteger count = new AtomicInteger();
        ladderRow.forEach(column -> count.getAndIncrement());
        assertThat(count.get()).isEqualTo(4);
    }

    @Test
    @DisplayName("사다리에서 연결된 다음 열은 연결되지 않는다.")
    void adjacentConnectionsDoNotOverlap() {
        LadderRow ladderRow = new LadderRow(5, () -> true);
        List<Boolean> expected = List.of(true, false, true, false);

        AtomicInteger index = new AtomicInteger();
        ladderRow.forEach(column -> {
            assertThat(column).isEqualTo(expected.get(index.getAndIncrement()));
        });
    }
}
