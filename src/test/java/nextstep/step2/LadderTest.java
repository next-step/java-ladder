package nextstep.step2;

import nextstep.step2.domain.Ladder;
import nextstep.step2.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 클래스 테스트")
public class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    @DisplayName("사다리타기 참여자, 사다리 높이 입력받아서 참여자 x 사다리높이 만큼 셋팅되는지 테스트")
    void inputNamesAndLadderHeightTest(int inputLadderHeight) {
        String names = "pobi,honux,crong,jk";
        Ladder ladder = new Ladder(names, inputLadderHeight);
        int joinedPeopleCount = ladder.getNames().getParticipantsCount();
        List<Line> ladders = ladder.getLadderLines().getLines();
        assertThat(ladders).hasSize(inputLadderHeight);
        ladders.forEach(line -> assertThat(line.getOneLayerLadder()).hasSize(joinedPeopleCount));
    }
}
