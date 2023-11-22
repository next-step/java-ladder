package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderResultTest {

    @Test
    @DisplayName("사다리타기를 끝내고 최종 포지션이 0, 1인 2명의 참가자가 있는경우 각각의 결과는 결과의 index와 동일하다.")
    void findPlayerResult() {
        GamersResult gamersResult = new GamersResult(Map.of(new Name("엄태권"), 0, new Name("태권"), 1));
        Results results = new Results(List.of("꽝", "당첨"), 2);

        LadderResult ladderResult = LadderResult.createLadderResult(gamersResult, results);
        Map<Name, Result> playerResult1 = ladderResult.findPlayerResult("엄태권");
        Map<Name, Result> playerResult2 = ladderResult.findPlayerResult("태권");

        assertThat(playerResult1).isEqualTo(Map.of(new Name("엄태권"), new Result("꽝")));
        assertThat(playerResult2).isEqualTo(Map.of(new Name("태권"), new Result("당첨")));
    }

    @Test
    @DisplayName("모든 사람(all)의 결과를 검색할 경우 모든 참여자의 결과를 반환한다.")
    void findPlayerResult_all() {
        GamersResult gamersResult = new GamersResult(Map.of(new Name("엄태권"), 0, new Name("태권"), 1));
        Results results = new Results(List.of("꽝", "당첨"), 2);

        LadderResult ladderResult = LadderResult.createLadderResult(gamersResult, results);
        Map<Name, Result> playerResult = ladderResult.findPlayerResult("all");

        assertThat(playerResult).hasSize(2)
                .containsEntry(new Name("엄태권"), new Result("꽝"))
                .containsEntry(new Name("태권"), new Result("당첨"));
    }

    @Test
    @DisplayName("사다리 게임에 참여하지 않는 사람의 결과를 검색시 오류가 발생한다.")
    void findPlayerResult_없는사람() {
        GamersResult gamersResult = new GamersResult(Map.of(new Name("엄태권"), 0, new Name("태권"), 1));
        Results results = new Results(List.of("꽝", "당첨"), 2);

        LadderResult ladderResult = LadderResult.createLadderResult(gamersResult, results);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> ladderResult.findPlayerResult("없는사람"))
                .withMessage("참가자 명단에 없는 사람입니다. 참가자 명단에 있는 사람 혹은 all을 입력 부탁드립니다.");
    }
}
