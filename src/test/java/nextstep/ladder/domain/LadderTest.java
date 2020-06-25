package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {

    @DisplayName("첫번째 라인은 최대높이-1 만큼의 Point 무조건 생성하고, 두번째 라인은 첫번쨰 라인과 연결되는 포인트가 아닌 3번쨰 포인트연결을 생성한다.")
    @Test
    void createLadder() {
        //given
        Ladder ladder = Ladder.of(3, () -> true, 3);

        //then
        /*
        | ------ |        |
        | ------ |        |
        |        | ------ |
         */
        assertAll(
                () -> assertThat(ladder.hasConnection(1, 1)).isTrue(),
                () -> assertThat(ladder.hasConnection(1, 2)).isTrue(),
                () -> assertThat(ladder.hasConnection(1, 3)).isFalse(),
                () -> assertThat(ladder.hasConnection(2, 3)).isTrue()
        );
    }


}