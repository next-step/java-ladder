package nextstep.ladder.service;

import nextstep.ladder.domain.Reward;
import nextstep.ladder.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @DisplayName("사다리 타기 결과 Reward 테스트")
    @Test
    void findOf_보상테스트() {
        // given
        Map<User, Reward> given = new HashMap<>();
        given.put(User.valueOf("seok", 0), Reward.valueOf("good"));
        given.put(User.valueOf("rae", 1), Reward.valueOf("not good"));
        // when
        LadderResult ladderResult = LadderResult.valueOf(given);
        String reward1 = ladderResult.findOf(User.valueOf("seok"));
        String reward2 = ladderResult.findOf(User.valueOf("rae"));
        // then
        assertThat(reward1).isEqualTo("good");
        assertThat(reward2).isEqualTo("not good");
    }

    @DisplayName("사다리 타기 전체 결과 테스트")
    @Test
    void testCase2() {
        Map<User, Reward> given = new HashMap<>();
        given.put(User.valueOf("seok", 0), Reward.valueOf("good"));
        given.put(User.valueOf("rae", 1), Reward.valueOf("not good"));

        LadderResult ladderResult = LadderResult.valueOf(given);

        assertThat(ladderResult.findAll()).contains("seok : good");
    }
}
