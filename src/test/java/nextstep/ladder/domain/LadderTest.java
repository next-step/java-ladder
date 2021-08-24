package nextstep.ladder.domain;

import nextstep.ladder.dto.LadderBarStatusDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("getLadderBarStatus 테스트")
    public void getLadderBarStatus() {
        // given
        Ladder ladder = new Ladder(new Players("a,b,c"), new Height("3"));
        int expectedHeight = 3;
        int expectedWidth = 2;

        // when
        LadderBarStatusDto ladderBarStatus = ladder.getLadderBarStatus();
        int height = ladderBarStatus.getLineBarStatus()
                .size();
        int width = ladderBarStatus.getLineBarStatus()
                .get(0)
                .getBarStatus()
                .size();

        // then
        assertThat(height).isEqualTo(expectedHeight);
        assertThat(width).isEqualTo(expectedWidth);
    }

}