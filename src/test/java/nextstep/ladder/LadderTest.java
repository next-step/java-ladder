package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("최대 높이만큼 라인을 만듭니다.")
    @Test
    void createLines(){
        Ladder ladder = Ladder.from(5);
        assertThat(ladder.ladderSize()).isEqualTo(5);
    }

}
