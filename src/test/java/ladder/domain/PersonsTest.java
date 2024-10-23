package ladder.domain;

import ladder.domain.Persons;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PersonsTest {

    @Test
    void 참가자_이름_리스트_저장_성공() {
        assertThat(new Persons("pobi,honux,crong,jk")).isEqualTo(new Persons("pobi", "honux", "crong", "jk"));
    }

    @Test
    void 참가자_이름_리스트_저장_길이_실패() {
        assertThatThrownBy(() -> new Persons("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("참여 인원은 2명이상이어야 합니다.");
    }

}
