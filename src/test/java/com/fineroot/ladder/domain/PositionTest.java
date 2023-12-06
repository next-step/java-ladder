package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fineroot.ladder.utils.ExceptionMessage;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {
    @Test
    @DisplayName("Position 생성")
    void create() {
        assertThat(new Position(0)).isInstanceOf(Position.class);
    }

    @Test
    @DisplayName("음수 Position 생성시 예외발생")
    void create_should_throw_exception_negative() {
        assertThatThrownBy(()->new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.POSITION_NEGATIVE.getMessage());
    }

    @ParameterizedTest
    @DisplayName("Position 비교")
    @CsvSource({"0,true","1,false"})
    void equals(int input, boolean expected) {
        assertThat(new Position(0).equals(new Position(input))).isEqualTo(expected);
    }

    @Test
    @DisplayName("Position move")
    void getFromList() {
        assertThat(new Position(0).getFromList(List.of(1,2,3,4,5))).isOne();
    }

    @Test
    @DisplayName("1 증가된 Position")
    void increase() {
        assertThat(new Position(0).increase()).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("1 감소된 Position")
    void decrease() {
        assertThat(new Position(1).decrease()).isEqualTo(new Position(0));
    }

    @Test
    @DisplayName("0을 1 감소시켜 예외 발생")
    void decrease_should_throw_exception() {
        assertThatThrownBy(()->new Position(0).decrease())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.POSITION_NEGATIVE.getMessage());
    }
}
