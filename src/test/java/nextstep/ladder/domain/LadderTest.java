package nextstep.ladder.domain;

import nextstep.ladder.common.Common;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("UserInput과 사다리 생성 전략을 이용하여 Ladder 객체를 만들 수 있다.")
    void testLadderConstructor() {
        //given, when
        final Ladder ladder = Common.makeRandomLadder("1,2,3", "꽝,1000,5000", 5);

        //then
        assertThat(ladder).isNotNull();
    }

    @RepeatedTest(10)
    @DisplayName("run 메서드를 실행시키면, 사다리 게임 실행 결과인 LadderResult 객체를 반환한다.")
    void testRun() {
        //given
        final Ladder ladder = Common.makeRandomLadder("pobi,honux,crong,jk", "꽝,1000,5000,꽝", 5);

        //when
        final LadderResult result = ladder.run();

        //then
        assertThat(result).isNotNull();
    }
}
