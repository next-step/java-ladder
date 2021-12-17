package nextstep.ladder.model;

import nextstep.ladder.model.value.LadderResult;
import nextstep.ladder.model.value.Participant;
import nextstep.ladder.model.value.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultsTest {

    @Test
    @DisplayName("사다리 결과 입력했을 때 원하는 만큼 결과 생성 되는지 검증")
    void createTest() {
        LadderResults ladderResult = LadderResults.of("꽝,5000,꽝,꽝");

        List<LadderResult> results = ladderResult.getLadderResults();

        assertThat(results.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("참가자의 결과를 정상적으로 보여주는지 확인")
    void resultTest() {
        LadderResults ladderResults = LadderResults.of("꽝,5000,꽝,꽝");
        Participant participant = new Participant("lee", new Position(1));

        assertThat(ladderResults.get(participant)).isEqualTo(new LadderResult("5000"));
    }
}
