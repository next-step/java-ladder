package ladder.domain;

import ladder.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTests {

    @DisplayName("Ladder 의 높이, 폭 가져올 수 있는지 테스트")
    @Test
    void getLadderHeightWidthTest() {
        Ladder ladder = getLadder();

        ResultView.drawLadder(ladder);

        assertThat(ladder.getLadderHeight()).isEqualTo(5);
        assertThat(ladder.getLadderWidth()).isEqualTo(4);
    }


    @DisplayName("Ladder 그렸을 때 옆에 붙어 있는 line 은 표시 안 되있는지 테스트")
    @Test
    void havePointsTest() {
        Ladder ladder = getLadder();

        ResultView.drawLadder(ladder);

        assertThat(ladder.havePoints(1, 1)).isNotEqualTo(ladder.havePoints(1, 2));
    }

    private Ladder getLadder() {
        List<String> participatePerson = new ArrayList<>(Arrays.asList("pobi", "honux", "crong", "jk"));
        int ladderMaxLength = 5;
        int countOfPerson = participatePerson.size();

        return Ladder.of(ladderMaxLength, countOfPerson);
    }

}
