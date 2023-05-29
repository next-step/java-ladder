package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CodeTest {

    @DisplayName("input이 all이면 true를 반환한다.")
    @Test
    void test1() {
        String input = "all";

        assertThat(Code.contains(input))
                .isTrue();
    }

    @DisplayName("input이 대문자(ALL)이면 true를 반환한다.")
    @Test
    void test2() {
        String input = "ALL";

        assertThat(Code.contains(input))
                .isTrue();
    }

    @DisplayName("input이 exit이면 true를 반환한다.")
    @Test
    void test3() {
        String input = "exit";

        assertThat(Code.contains(input)).isTrue();
    }

    @DisplayName("input이 대문자(EXIT)이면 true를 반환한다.")
    @Test
    void test4() {
        String input = "EXIT";

        assertThat(Code.contains(input)).isTrue();
    }


    @DisplayName("input이 Code에 포함되지 않으면(all이나 exit이 아니면) false를 반환한다.")
    @Test
    void test5() {
        String input = "aaa";

        assertThat(Code.contains(input)).isFalse();
    }
}