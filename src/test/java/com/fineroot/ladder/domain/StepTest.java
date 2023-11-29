package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StepTest {
    @Test
    @DisplayName("Step 생성")
    void create() {
        assertThat(Step.from(Bar.first(true))).isInstanceOf(Step.class);
    }
}
