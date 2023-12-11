package nextstep.ladder.service;

import nextstep.ladder.domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderServiceTest {
    @Test
    @DisplayName("높이 만큼 사다리 높이가 생성된다.")
    void line_Vertical_Test() {
        Ladder ladder = LadderService.generateLadder(4, 3);
        System.out.println("ladder.toString() = " + ladder.toString());

        assertThat(ladder.getHeight()).isEqualTo(3);
    }
}
