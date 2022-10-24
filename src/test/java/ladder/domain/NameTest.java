package ladder.domain;

import ladder.domain.Name;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    public void 이름_최대5글자() {
        assertThatThrownBy(() -> new Name("abcedf"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 최대 5글자까지 부여할 수 있습니다.");
    }

    @Test
    public void 이름_생성() {
        Name name = new Name("test");
        assertThat(name).isEqualTo(new Name("test"));
    }

    @Test
    public void 이름_5글자_기준으로_출력() {
        Name name = new Name("abc");
        assertThat(name.resultName().length()).isEqualTo(5);
        assertThat(name.resultName()).isEqualTo("  abc");
    }
}
