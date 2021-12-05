package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderInFoTest {

    @Test
    void 사다리_정보를_생성한다() {
        //given
        LadderInfo ladderInfo = LadderInfo.of(4, 5);
        //when & then
        assertThat(ladderInfo).isEqualTo(LadderInfo.of(4, 5));
    }

    @Test
    void 사다리_정보에_음수를_입력하면_IllegalArgumentException이_발생한다() {
        //given
        //when & then
        assertAll(
                () -> assertThatThrownBy(() -> LadderInfo.of(-4, 5), "width는 음수를 허용하지 않습니다.")
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> LadderInfo.of(4, -5), "height는 음수를 허용하지 않습니다.")
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
