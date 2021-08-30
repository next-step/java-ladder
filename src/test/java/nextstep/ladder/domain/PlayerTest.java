package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerTest {

    @DisplayName("이름과 번호가 같으면 동일 객체다.")
    @Test
    void create() {
        Player pobi = new Player("pobi", 0);
        assertThat(pobi).isEqualTo(new Player("pobi", 0));
    }

    @DisplayName("이름이 5글자 이상이거나 빈 글자면 생성 실패")
    @Test
    void create_fail() {
        assertThrows(IllegalArgumentException.class,
                () -> new Player("다섯글자이상", 1));
    }

}