package nextstep.ladder.domain;

import nextstep.ladder.domain.player.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @DisplayName("이름 생성 시 에러 발생")
    @Test
    void create_with_invalid_input() {
         assertThatThrownBy(() -> new Name("computer"))
                 .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("이름 출력 시 글자 수 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "honux", "crong", "jk"} )
    void name_toString(String name) {
        int NAME_UPPER_BOUND = 5;

        assertThat(new Name(name).toString().length())
                .isEqualTo(NAME_UPPER_BOUND);
    }

    @DisplayName("이름 비교 테스트")
    @Test
    void equals() {
        assertThat(new Name("pobi"))
                .isEqualTo(new Name("pobi"));
    }
}
