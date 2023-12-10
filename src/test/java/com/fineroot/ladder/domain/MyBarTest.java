package com.fineroot.ladder.domain;

import static com.fineroot.ladder.utils.ExceptionMessage.STEP_ROW_LINE_BOTH_TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fineroot.ladder.engine.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MyBarTest {

    @Test
    @DisplayName("Bar 생성")
    void create_of() {
        assertThat(MyBar.of(false,true)).isInstanceOf(MyBar.class);
    }

    @Test
    @DisplayName("Bar 생성시 전 값과 현재 값이 동시에 true이면 예외 발생")
    void create_should_throw_exception_when_both_true() {
        assertThatThrownBy(() -> MyBar.of(true,true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(STEP_ROW_LINE_BOTH_TRUE.getMessage());
    }

    @Test
    @DisplayName("Bar의 현재 스탭 유무")
    void current_step() {
        assertThat(MyBar.of(false,true).currentStep()).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"true, false, 0","false, true, 2","false, false, 1"})
    void move(boolean previousStepInput, boolean haveStep, int expected) {
        assertThat(MyBar.of(previousStepInput, haveStep).move(new Position(1))).isEqualTo(new Position(expected));
    }
}
