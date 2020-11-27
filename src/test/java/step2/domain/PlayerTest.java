package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.NameLengthException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("네임이 5글자를 초과하는경우 익셉션 발생")
    void throwNameException() {
        assertThatThrownBy(()-> Player.of("abcedf"))
                .isInstanceOf(NameLengthException.class);
    }
    @Test
    @DisplayName("플레이어가 잘 생성되는지 확인")
    void name() {

    }
}