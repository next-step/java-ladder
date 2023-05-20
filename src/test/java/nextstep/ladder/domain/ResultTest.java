package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.utils.PositionMaker.makePosition;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @DisplayName("결과 정보에 공백을 넣을경우 에러를 던진다.")
    @Test
    void 결과_공백시_에러() {
        assertThatThrownBy(() -> new Result(" ", makePosition(0,0))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Result 클래스 생성 시 결과 Position을 할당하는데 isReach 메서드 호출 시 해당 위치에 포지션이 아닐경우 false를 리턴한다.")
    @Test
    void 도착_위치_검증() {
        assertAll(
                () -> assertThat(new Result("result", makePosition(0, 5)).isReach(makePosition(0, 5))).isTrue(),
                () -> assertThat(new Result("result", makePosition(0, 5)).isReach(makePosition(3, 5))).isFalse()
        );
    }
}