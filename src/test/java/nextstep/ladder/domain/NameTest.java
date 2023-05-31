package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThat;

class NameTest {
    @Test
    @DisplayName("이름 생성")
    public void name() {
        assertThat(new Name("pobi").getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("이름은 5글자를 초과할 수 없다")
    public void invalidName_longName() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name("abcdef"));
    }

    @Test
    @DisplayName("'all'이라는 이름은 사용할 수 없다")
    public void invalidName_all() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name("all"));
    }
}
