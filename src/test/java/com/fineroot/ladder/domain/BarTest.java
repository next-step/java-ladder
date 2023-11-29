package com.fineroot.ladder.domain;

import static com.fineroot.ladder.utils.ExceptionMessage.STEP_ROW_LINE_BOTH_TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BarTest {
    @Test
    @DisplayName("Bar 생성")
    void create() {
        assertThat(Bar.first(true)).isInstanceOf(Bar.class);
    }

    @Test
    @DisplayName("Bar 생성시 전 값과 현재 값이 동시에 true이면 예외 발생")
    void create_should_throw_exception_when_both_true() {
        Bar bar = Bar.first(true);

        assertThatThrownBy(() -> bar.next( true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(STEP_ROW_LINE_BOTH_TRUE.getMessage());
    }

    @Test
    @DisplayName("Line의 첫 Bar")
    void create_first() {
        assertThat(Bar.first(true)).isInstanceOf(Bar.class);
    }

    @Test
    @DisplayName("Line의 마지막 Bar")
    void create_last() {
        assertThat(Bar.first(true).last()).isInstanceOf(Bar.class);
    }

    @Test
    @DisplayName("Bar의 현재 스탭 유무")
    void current_step() {
        assertThat(Bar.first(true).currentStep()).isTrue();
    }
}
