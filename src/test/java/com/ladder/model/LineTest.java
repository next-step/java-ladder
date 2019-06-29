package com.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("랜덤한 위치를 갖는 한 개의 라인을 생성한다")
    @Test
    void createLine_success() {
        // given
        int numberOfPerson = 5;
        // when
        Line positions = Line.of(numberOfPerson);
        // then
        assertThat(positions).isNotNull();
        assertThat(positions.getPoints()).hasSize(numberOfPerson);
    }

    @DisplayName("위치를 갖는 한 개의 라인을 생성한다")
    @Test
    void createLine_hasStrategy_success() {
        // given
        int numberOfPerson = 2;
        // when
        Line positions = Line.of(numberOfPerson, ()-> true);
        // then
        assertThat(positions).isNotNull();
        assertThat(positions.getPoints()).containsExactly(true, false);
    }

}
