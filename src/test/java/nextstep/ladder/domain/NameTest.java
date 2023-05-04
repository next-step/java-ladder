package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    @DisplayName("Name 생성")
    void test01() {
        Name name = new Name("rang");

        assertThat(name.name()).isEqualTo("rang");
    }

    @Test
    @DisplayName("이름이 5글자 초과하면 에러 발생")
    void test02() {
        assertThatThrownBy(() -> new Name("saerang")).isInstanceOf(IllegalArgumentException.class);
    }
}
