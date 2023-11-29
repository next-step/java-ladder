package nextstep.ladder.model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    @DisplayName("이름의 길이는 1자 ~ 5자 이다")
    void name_length() {
        Assertions.assertThatThrownBy(() -> {
            new Name("123456");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이름의 길이는 1자 ~ 5자 입니다");

        Assertions.assertThatThrownBy(() -> {
                new Name("");
            }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이름의 길이는 1자 ~ 5자 입니다");
    }
}