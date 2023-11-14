package me.namuhuchutong.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HyphenTest {

    @DisplayName("Hyphen 객체는 - 를 요소로 가진다.")
    @Test
    void check_hyphen_object_correct_element() {
        //given
        Character hyphen = '-';
        LadderExpression created = Hyphen.create();

        //when
        boolean result = hyphen.equals(created.getValue());

        //then
        assertThat(result).isTrue();
    }
}
