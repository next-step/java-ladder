package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderRowTest {

    @Test
    @DisplayName("주어진 너비(width) 만큼의 line을 생성한다.")
    public void create_Width_Line() {
        LadderRow ladderRow = new LadderRow(5);
        Assertions.assertThat(ladderRow.size()).isEqualTo(5);
    }

}
