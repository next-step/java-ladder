package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @DisplayName("결과 정보에 공백을 넣을경우 에러를 던진다.")
    @Test
    void 결과_공백시_에러() {
        assertThatThrownBy(() -> new Result(" ", new Position(0, 0))).isInstanceOf(IllegalArgumentException.class);
    }

}