package me.namuhuchutong.ladder;

import me.namuhuchutong.ladder.domain.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NamesTest {

    @DisplayName("이름 목록이 주어지면, 이름 객체들을 생성한다.")
    @Test
    void given_string_creates_names_object() {
        String givenNames = "a,b,c,d";
        int expected = 4;

        Names names = Names.from(givenNames);
        int actual = names.size();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("사다리 게임은 최소 2명이 있어야 한다.")
    @Test
    void ladder_game_requires_at_least_2_names() {
        String givenNames = "a";

        assertThatThrownBy(() -> Names.from(givenNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}