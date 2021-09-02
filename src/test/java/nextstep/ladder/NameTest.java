package nextstep.ladder;

import nextstep.ladder.domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameTest {
    @Test
    @DisplayName("참여자의 이름은 5글자가 넘어 가면 안된다.")
    void create() {
        assertThatThrownBy(()-> new Name("geonhee")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("all은 사용할 수 없는 이름이다.")
    void create2() {
        assertThatThrownBy(()-> new Name("all")).isInstanceOf(IllegalArgumentException.class);
    }


}