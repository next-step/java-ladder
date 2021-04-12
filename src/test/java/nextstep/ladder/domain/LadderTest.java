package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("입력받은 사다리 높이 수 만큼 라인을 생성한다.")
    public void create() throws Exception {
        Ladder ladder = new Ladder(new Height(5), new CountOfPlayer(4));
        assertThat(ladder.lines()).hasSize(5);
    }
}