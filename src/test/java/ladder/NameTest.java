package ladder;

import ladder.domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {

    @Test
    @DisplayName("Name 생성 테스트")
    void create() {
        String name = "tests";
        Name test = new Name(name);
        assertThat(test).isEqualTo(new Name(name));
    }

    @Test
    @DisplayName("Name 생성시 이름이 다섯자 초과이면 예외 발생 테스트")
    void create_with_name_more_than_5() {
        String name = "testss";
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Name(name));
    }
}
