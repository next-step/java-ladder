package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("Ladder를 생성했을 떄 주어진 넓이와 높이만큼의 map이 생성된다.")
    void initTest() {
        Ladder ladder = new Ladder(new PositiveNumber(3), new PositiveNumber(5));
        List<LadderRow> ladderMap = ladder.getMap();
        assertThat(ladderMap).hasSize(5);
        ladderMap.forEach(row ->
                assertThat(row.getRow()).hasSize(3)
        );
    }
}