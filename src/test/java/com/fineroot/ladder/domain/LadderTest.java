package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

    @Test
    @DisplayName("Ladder 생성")
    void create() {
        Ladder ladder = Ladder.of(Users.fromString("a,b,c,d"), 5);
        assertThat(ladder).isInstanceOf(Ladder.class);
    }

    @Test
    @DisplayName("Ladder toString")
    void toStringTest() {
        Ladder ladder = Ladder.of(Users.fromString("aaaa,bbbbb,ccccc,ddd"), 5);
        assertThat(ladder.toString()).isInstanceOf(String.class);
    }

    @ParameterizedTest
    @DisplayName("실행 결과 하나만")
    @CsvSource({"0,0", "1,3", "2,2", "3,1"})
    void resultOne(int actualInput, int expected) {
        Ladder ladder = Ladder.fromBooleanArrays(
                new Boolean[][]{{true, false, true},
                        {false, true, false},
                        {true, false, false},
                        {false, true, false},
                        {true, false, true}}, 4);
        Position actual = ladder.resultOne(new Position(actualInput));
        assertThat(actual).isEqualTo(new Position(expected));
    }

    @Test
    @DisplayName("전체 실행 결과")
    void resultAll() {
        Ladder ladder = Ladder.fromBooleanArrays(
                new Boolean[][]{{true, false, true},
                        {false, true, false},
                        {true, false, false},
                        {false, true, false},
                        {true, false, true}}, 4);
        assertIterableEquals(ladder.resultAll(),
                List.of(new Position(0), new Position(3), new Position(2), new Position(1)));
    }
}
