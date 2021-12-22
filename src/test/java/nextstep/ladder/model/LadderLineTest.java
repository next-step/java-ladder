package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {
    private static final int VALID_USER_SIZE = 5;

    @Test
    void initTest() {
        // when
        LadderLine ladderLine = LadderLine.init(VALID_USER_SIZE);
        // then
        assertThat(ladderLine).isNotNull();
    }

    @Test
    void getPointsTest() {
        // given
        LadderLine ladderLine = LadderLine.init(VALID_USER_SIZE);
        // when & then
        assertThat(ladderLine.getPoints()).hasSize(VALID_USER_SIZE);
    }
}
