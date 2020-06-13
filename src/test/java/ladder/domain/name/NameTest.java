package ladder.domain.name;

import ladder.domain.name.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {

    private final String name = "name";

    @DisplayName("Name 생성 실패: null 또는 빈 문자열")
    @ParameterizedTest
    @NullAndEmptySource
    void createFailure(final String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Name.of(name));
    }

    @DisplayName("Name 생성 실패: 5글자 이상의 문자열")
    @Test
    void createFailure() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Name.of("heejeong"));
    }

    @DisplayName("이름 문자열을 반환")
    @Test
    void create() {
        assertThat(Name.of(name).getName())
                .isEqualTo(name);
    }

    @DisplayName("논리적 동치성 비교")
    @Test
    void equals() {
        assertThat(Name.of(name))
                .isEqualTo(Name.of(name));
    }
}
