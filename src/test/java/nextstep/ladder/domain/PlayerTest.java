package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @DisplayName("이름과 번호가 같으면 동일 객체다.")
    @Test
    void create(){
        Player pobi = new Player("pobi", 0);
        assertThat(pobi).isEqualTo(new Player("pobi", 0));
    }

}