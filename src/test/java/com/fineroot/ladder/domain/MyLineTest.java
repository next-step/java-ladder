package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.ladder.engine.Line;
import com.fineroot.ladder.engine.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MyLineTest {
    @Test
    @DisplayName("Line 생성")
    void create(){
        MyLineCreator myLineCreator = new MyLineCreator(new MyBarCreator());
        Line line = myLineCreator.create(true, false, true);
        assertThat(line).isInstanceOf(MyLine.class);
    }

    @Test
    @DisplayName("toString")
    void toStringTest(){
        MyLineCreator myLineCreator = new MyLineCreator(new MyBarCreator());
        Line line = myLineCreator.create(true, false, true);
        assertThat(line).hasToString("|-----|     |-----|");
    }

    @ParameterizedTest
    @DisplayName("move")
    @CsvSource({"0,1","1,0","2,3","3,2"})
    void move(int actual, int expected){
        MyLineCreator myLineCreator = new MyLineCreator(new MyBarCreator());
        Line line = myLineCreator.create(true, false, true);
        assertThat(line.move(new Position(actual))).isEqualTo(new Position(expected));
    }
}
