package nextstep.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @Test
    void 이름이_5글자_이상으로_Player_생성시_예외가_반환된다() {
        assertThatThrownBy(() -> new Player("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
