package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
    @Test
    @DisplayName("Line 생성")
    void create(){
        Line line = Line.from(Users.fromString("aaaaa,b,c,d,e"));
        assertThat(line).isInstanceOf(Line.class);
    }

    @Test
    @DisplayName("toString")
    void toStringTest(){
        Line line = Line.fromBooleanArray(true, false, true);
        assertThat(line).hasToString("|-----|     |-----|");
    }
}
