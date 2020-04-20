package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderGameInfoTest {
    @Test
    void create() {
        assertThat(new LadderGameInfo(Users.of("참가자 1,참가자 2"), LadderRewards.of("꽝,당첨"))).isNotNull();
    }

    @Test
    void exceptionByCreation() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderGameInfo(Users.of("참가자 1,참가자 2"), LadderRewards.of("꽝,꽝,당첨"));
        }).withMessage("참여할 사람과 실행 결과의 수는 같아야 한다.");

    }
}
