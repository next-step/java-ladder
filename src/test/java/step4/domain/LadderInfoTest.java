package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderInfoTest {

    @Test
    void 사다리_정보를_생성한다() {
        //given
        LadderInfo ladderInfo = LadderInfo.of(5, 3);
        //when
        //then
        assertThat(ladderInfo).isEqualTo(LadderInfo.of(5, 3));
    }
}
