package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @DisplayName("사다리 게임에서 사용되는 이름, 결과값들은 글자수가 5자리 이하여야 한다.")
    @Test
    void create() {
        assertThrows(IllegalArgumentException.class, () -> new Name("다섯자리이상"));
    }
}