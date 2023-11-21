package nextstep.ladder.domian;

import nextstep.ladder.domain.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {

    private Names names;

    @DisplayName("여러 이름을 생성한다")
    @Test
    void 여러_이름을_생성한다() {
        names = new Names("pobi,crong,honux");
    }

    @DisplayName("이름의 갯수를 확인한다")
    @Test
    void 이름의_갯수를_확인한다() {
        names = new Names("pobi,crong,honux");
        assertThat(names.size()).isEqualTo(3);
    }
}
