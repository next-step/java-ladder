package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DirectionTest {
    @ParameterizedTest
    @DisplayName("get")
    @CsvSource({"LEFT,0","RIGHT,2","PASS,1"})
    void getMovement(Direction actual, int expected) {
        assertThat(actual.getMovement().apply(new Position(1))).isEqualTo(new Position(expected));
    }
}
