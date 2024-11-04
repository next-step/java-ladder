package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonTest {

    @Test
    void person_이름_저장_에러_테스트() {

        assertThatThrownBy(() -> new Person("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("이름은 5글자를 넘을 수 없습니다.");
    }

    @Test
    void person_이름_저장_all_에러_테스트() {
        assertThatThrownBy(() -> new Person("all"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("all은 사용자 이름으로 사용 할 수 없습니다.");
    }

    @Test
    void person_개인_게임_결과_저장_테스트() {
        Person person = new Person("hyeo", 0);
        person.gameResultSave(2);
        assertThat(person.getPoint()).isEqualTo(2);
    }

}
