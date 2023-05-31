package ladder.domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("주어진 높이(height) 만큼의 row를 생성한다.")
    public void create_Height_Success() {
        int height = 5;
        int countOfPlayer =4;

        Ladder ladder = new Ladder(new LadderHeight(height), countOfPlayer);
        Assertions.assertThat(ladder.height()).isEqualTo(height);
    }

}
