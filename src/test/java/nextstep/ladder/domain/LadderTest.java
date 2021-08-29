package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("getLadderBarStatus 테스트")
    public void getLadderBarStatus() {
        // given
        Ladder ladder = new Ladder(new Players("a,b,c"), new Height(3));
        int expectedHeight = 3;
        int expectedWidth = 2;

        // when
        List<List<Boolean>> ladderBarStatus = ladder.getLadderBarStatus();
        int height = ladderBarStatus.size();
        int width = ladderBarStatus.get(0).size();

        // then
        assertThat(height).isEqualTo(expectedHeight);
        assertThat(width).isEqualTo(expectedWidth);
    }

}