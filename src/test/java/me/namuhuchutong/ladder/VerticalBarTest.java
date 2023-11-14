package me.namuhuchutong.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class VerticalBarTest {

    @DisplayName("VerticalBar 객체는 | 를 요소로 가진다.")
    @Test
    void check_vertical_bar_object_correct_element() {
        //given
        Character verticalBar = '|';
        LadderExpression created = VerticalBar.create();

        //when
        boolean result = verticalBar.equals(created.getValue());

        //then
        assertThat(result).isTrue();
    }
}
