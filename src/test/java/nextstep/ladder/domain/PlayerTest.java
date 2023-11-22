package nextstep.ladder.domain;

import nextstep.ladder.domain.wrapper.Width;
import nextstep.ladder.domain.wrapper.Height;
import nextstep.ladder.domain.wrapper.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @DisplayName("이름을 가진 Player를 생성하고, x,y축 값을 초기화 한다.")
    @Test
    void createPlayer() {
        // given
        Name name = new Name("홍길동");
        Width width = new Width(0);
        Height height = new Height(0);
        assertThat(new Player(name, width, height)).isEqualTo(new Player(name, width, height));
    }
}
