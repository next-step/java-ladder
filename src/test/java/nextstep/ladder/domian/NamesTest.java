package nextstep.ladder.domian;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("공백은 이름으로 인정하지 않는다")
    @Test
    void 공백은_이름으로_인정하지_않는다() {
        new assertThatThrownBy(() -> new Names("pobi,,honux")).isInstanceOf(BlankNameException.class);
    }
}
