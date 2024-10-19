package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderRowTest {
    @Test
    @DisplayName("LadderRow 객체를 생성할 때 주어진 넓이 만큼 사다리를 넓이를 생성한다.")
    void initTest() {
        LadderRow ladderRow = new LadderRow(new PositiveNumber(5), () -> true);
        assertThat(ladderRow.getRow()).hasSize(5);
    }
}