package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    @DisplayName("사람 수와 높이를 입력하여 사다리를 생성한다.")
    public void init() {
        int sizeOfPerson = 5;
        int height = 4;
        assertThat(Ladder.init(sizeOfPerson, height)).isInstanceOf(Ladder.class);
    }
}
