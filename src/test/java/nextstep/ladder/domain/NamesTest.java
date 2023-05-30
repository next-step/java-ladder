package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class NamesTest {
    @Test
    @DisplayName("Names 생성")
    public void names() {
        assertThat(new Names(List.of("pobi", "honux", "crong", "jk")).getNames()).containsExactly("pobi", "honux", "crong", "jk");
    }

    @Test
    @DisplayName("이름은 중복될 수 없다")
    public void duplicateNames() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Names(List.of("pobi", "pobi", "honux", "crong", "jk")));
    }

    @Test
    @DisplayName("입력받은 이름의 순서를 얻는다")
    public void getOrderOf() {
        Names names = new Names(List.of("pobi", "honux", "crong", "jk"));
        assertAll(
                () -> assertThat(names.getOrderOf("pobi")).isEqualTo(0),
                () -> assertThat(names.getOrderOf("honux")).isEqualTo(1),
                () -> assertThat(names.getOrderOf("crong")).isEqualTo(2),
                () -> assertThat(names.getOrderOf("jk")).isEqualTo(3)
        );
    }

    @Test
    @DisplayName("참여하지 않은 사람의 순서를 구할 수 없다")
    public void invalidNameToShowResult() {
        Names names = new Names(List.of("pobi", "honux", "crong"));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> names.getOrderOf("jk"));
    }
}