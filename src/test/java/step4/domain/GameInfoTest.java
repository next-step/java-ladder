package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class GameInfoTest {

    @Test
    void 참여자_수와_보상_수가_일치하지_않으면_IllegalArgumentException_이_발생한다() {
        //given
        //when & then
        assertAll(
                () -> assertThatThrownBy(
                        () -> GameInfo.of(Participants.of("a,b,c,d,a"), Rewards.of("1,2,3,4")))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(
                        () -> GameInfo.of(Participants.of("a,b,c,d"), Rewards.of("0,1,2,3,4")))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
