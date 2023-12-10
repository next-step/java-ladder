package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.ladder.engine.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MyLineTest {
    @Test
    @DisplayName("Line 생성")
    void create(){
        MyLine myLine = MyLine.fromBooleanArray(true, false, true);
        assertThat(myLine).isInstanceOf(MyLine.class);
    }

    @Test
    @DisplayName("toString")
    void toStringTest(){
        MyLine myLine = MyLine.fromBooleanArray(true, false, true);
        assertThat(myLine).hasToString("|-----|     |-----|");
    }

    @ParameterizedTest
    @DisplayName("move")
    @CsvSource({"0,1","1,0","2,3","3,2"})
    void move(int actual, int expected){
        MyLine myLine = MyLine.fromBooleanArray(true, false, true);
        assertThat(myLine.move(new Position(actual))).isEqualTo(new Position(expected));
    }
}
