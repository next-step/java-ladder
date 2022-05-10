package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    void 유효한_이름_생성() {
        Name name1 = new Name("1");
        Name name2 = new Name("12345");

        assertThat(name1.get()).isEqualTo("1");
        assertThat(name2.get()).isEqualTo("12345");
    }

    @Test
    void 짧아서_유효하지_않은_이름_생성() {
        assertThatThrownBy(() -> {
            new Name("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길어서_유효하지_않은_이름_생성() {
        assertThatThrownBy(() -> {
            new Name("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}