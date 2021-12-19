package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderResultTest {
    LadderResult ladderResult;
    @BeforeEach
    private void before() {
        ladderResult = new LadderResult(new Member("pobi"), new Reward("5000"));
    }

    @Test
    void 멤버_확인() {
        assertThat(ladderResult.isMember("pobi")).isTrue();
    }

    @Test
    void 멤버_이름_비교() {
        assertThat(ladderResult.getMemberName()).isEqualTo("pobi");
    }

    @Test
    void 실행결과_확인() {
        assertThat(ladderResult.getReward()).isEqualTo("5000");
    }
}