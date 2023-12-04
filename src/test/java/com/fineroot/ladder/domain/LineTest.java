package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LineTest {
    @Test
    @DisplayName("Line 생성")
    void create(){
        Line line = Line.fromBooleanArray(true, false, true);
        assertThat(line).isInstanceOf(Line.class);
    }

    @Test
    @DisplayName("toString")
    void toStringTest(){
        Line line = Line.fromBooleanArray(true, false, true);
        assertThat(line).hasToString("|-----|     |-----|");
    }

    @ParameterizedTest
    @DisplayName("move")
    @CsvSource({"0,1","1,0","2,3","3,2"})
    void move(int actual, int expected){
        Line line = Line.fromBooleanArray(true, false, true);
        assertThat(line.move(new Position(actual))).isEqualTo(new Position(expected));
    }
}
