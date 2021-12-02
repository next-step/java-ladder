package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderInFoTest {

    @Test
    void 사다리_정보를_생성한다() {
        //given
        LadderInfo ladderInfo = LadderInfo.of(4, 5);
        //when & then
        assertThat(ladderInfo).isEqualTo(LadderInfo.of(4, 5));
    }
}
