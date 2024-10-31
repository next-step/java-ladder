package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PersonsTest {

    @Test
    void 참가자_이름_리스트_저장_성공() {
        assertThat(Persons.from("pobi,honux,crong,jk")).isEqualTo(Persons.from("pobi", "honux", "crong", "jk"));
    }

    @Test
    void 참가자_이름_리스트_저장_길이_실패() {
        assertThatThrownBy(() -> Persons.from("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("참여 인원은 2명이상이어야 합니다.");
    }

    @Test
    void 참가자_동일한_이름_조회_테스트() {
        Persons persons = Persons.from("phobi,honux,cron,jk");
        assertThat(persons.isSamePerson("phobi").get()).isEqualTo(new Person("phobi"));
    }

}
