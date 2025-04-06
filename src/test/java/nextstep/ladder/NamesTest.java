package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class NamesTest {

    @Test
    @DisplayName("이름들을 쉼표 단위로 구분한다")
    void splitNames() {
        Names names = Names.of(List.of(
                Name.of("pobi"),
                Name.of("honux"),
                Name.of("crong"),
                Name.of("jk")));
        Assertions.assertThat(names.getListNames()).containsExactly(
                Name.of("pobi"),
                Name.of("honux"),
                Name.of("crong"),
                Name.of("jk"));
    }

}
