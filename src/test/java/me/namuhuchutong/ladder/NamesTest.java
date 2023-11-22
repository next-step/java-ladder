package me.namuhuchutong.ladder;

import me.namuhuchutong.ladder.domain.Names;
import me.namuhuchutong.ladder.domain.wrapper.Name;
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

    @DisplayName("존재하지 않는 이름을 찾을 경우 예외가 발생한다.")
    @Test
    void throw_exception_when_name_is_not_exist() {
        String givenNames = "a,b,c";
        Name givenName = new Name("d");
        Names createdNames = Names.from(givenNames);

        assertThatThrownBy(() -> createdNames.getSequence(givenName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주어진 인덱스가 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void throw_exception_when_index_is_exceed() {
        String givenNames = "a,b,c";
        Names createdNames = Names.from(givenNames);
        int givenIndex = 10;

        assertThatThrownBy(() -> createdNames.getNthName(givenIndex))
                .isInstanceOf(IllegalArgumentException.class);
    }
}