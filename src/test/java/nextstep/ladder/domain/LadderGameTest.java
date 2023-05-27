package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


class LadderGameTest {

    @Test
    public void 사다리게임_생성_테스트() throws Exception {
        LadderHeight ladderHeight1 = new LadderHeight(3);
        UserNames userNames = UserNames.of(Arrays.asList(UserNameTest.POBI, UserNameTest.CRONG));
        assertThat(LadderGame.create(ladderHeight1, userNames))
                .isNotNull()
                .isInstanceOf(LadderGame.class);
    }
}
