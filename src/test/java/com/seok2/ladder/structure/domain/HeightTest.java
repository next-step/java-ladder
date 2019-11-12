package com.seok2.ladder.structure.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import com.seok2.ladder.user.domain.Participants;
import org.junit.jupiter.api.Test;

class HeightTest {

    @Test
    void throwException() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Height.of(-1))
            .withMessage("사다리의 높이는 0보다 작을 수 없습니다.");
    }

    @Test
    void intValue() {
        assertThat(Height.of(10).intValue()).isEqualTo(10);
    }
}