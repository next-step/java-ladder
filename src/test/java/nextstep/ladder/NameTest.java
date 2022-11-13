package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.ladder.domain.Name;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    void testCreateNameSuccess() {
        Name name = new Name("name");
        assertThat(name.toString()).isEqualTo("name");
    }

    @Test
    void testCreateNameFail() {
        assertThatThrownBy(() -> new Name("failName"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름은 최대 5글자까지 입력할 수 있습니다.");
    }

}
