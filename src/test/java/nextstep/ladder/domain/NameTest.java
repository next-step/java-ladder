package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    @DisplayName("이름 생성 테스트")
    void initNameTest() {
        Name name = new Name("test1");

        assertThat(name)
                .isInstanceOf(Name.class);
    }

    @Test
    @DisplayName("이름이 5글자 초과시 에러 테스트")
    void nameLengthOverErrorTest() {
        String name = "abcdef";

        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름 길이는 5글자를 초과할 수 없습니다. - " + name);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈칸일때 에러 반환 테스트")
    void nullOrEmptyTest(String input) {
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자 이름을 입력하지 않았습니다. 입력해주세요.");
    }


}