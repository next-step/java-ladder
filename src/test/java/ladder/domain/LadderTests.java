package ladder.domain;

import ladder.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTests {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Line line = Line.of(Arrays.asList(true, false, false, true));
        Ladder ladder = Ladder.of(Arrays.asList(line));

        assertThat(ladder).isEqualTo(Ladder.of(Arrays.asList(Line.of(Arrays.asList(true, false, false, true)))));
    }

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

    @DisplayName("참가 번호 전달 했을 때 해당하는 사다리의 이동 후 결과 번호를 잘 리턴하는지 테스트")
    @Test
    void moveTest() {
        Line line1 = Line.of(Arrays.asList(false, false, false, true));
        Line line2 = Line.of(Arrays.asList(false, true, false, true));
        Line line3 = Line.of(Arrays.asList(false, false, true, false));

        Ladder ladder = Ladder.of(Arrays.asList(line1, line2, line3));

        ResultView.drawLadder(ladder);

        assertThat(ladder.movedPosition(2)).isEqualTo(1);
    }


}
