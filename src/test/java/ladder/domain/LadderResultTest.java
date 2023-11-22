package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderResultTest {

    private Names names;
    private Results results;
    private Positions positions;
    private Gamers gamers;

    @BeforeEach
    void init() {
        this.names = new Names(List.of("엄태권", "태권"));
        this.results = new Results(List.of("꽝", "당첨"), 2);
        this.positions = new Positions(List.of(new Position(0), new Position(1)));
        this.gamers = new Gamers(this.names, this.positions);
    }

    @Test
    @DisplayName("사다리타기를 끝내고 최종 포지션이 0, 1인 2명의 참가자가 있는경우 각각의 결과는 결과의 index와 동일하다.")
    void findPlayerResult() {
        LadderResult ladderResult = LadderResult.createLadderResult(this.gamers, this.results);
        Map<Name, Result> playerResult1 = ladderResult.findPlayerResult("엄태권");
        Map<Name, Result> playerResult2 = ladderResult.findPlayerResult("태권");

        assertThat(playerResult1).isEqualTo(Map.of(new Name("엄태권"), new Result("꽝")));
        assertThat(playerResult2).isEqualTo(Map.of(new Name("태권"), new Result("당첨")));
    }

    @Test
    @DisplayName("모든 사람(all)의 결과를 검색할 경우 모든 참여자의 결과를 반환한다.")
    void findPlayerResult_all() {
        LadderResult ladderResult = LadderResult.createLadderResult(this.gamers, this.results);
        Map<Name, Result> playerResult = ladderResult.findPlayerResult("all");

        assertThat(playerResult).hasSize(2)
                .containsEntry(new Name("엄태권"), new Result("꽝"))
                .containsEntry(new Name("태권"), new Result("당첨"));
    }

    @Test
    @DisplayName("모든 사람(all)의 결과를 검색할 경우 결과의 상태는 마지막임을 나타낸다.")
    void findPlayerResult_all_endResult() {
        LadderResult ladderResult = LadderResult.createLadderResult(this.gamers, this.results);
        ladderResult.findPlayerResult("all");

        assertThat(ladderResult.isEndResult()).isEqualTo(true);
    }

    @Test
    @DisplayName("사다리 게임에 참여하지 않는 사람의 결과를 검색시 오류가 발생한다.")
    void findPlayerResult_없는사람() {
        LadderResult ladderResult = LadderResult.createLadderResult(this.gamers, this.results);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> ladderResult.findPlayerResult("없는사람"))
                .withMessage("참가자 명단에 없는 사람입니다. 참가자 명단에 있는 사람 혹은 all을 입력 부탁드립니다.");
    }
}