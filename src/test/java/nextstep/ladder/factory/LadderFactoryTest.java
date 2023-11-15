package nextstep.ladder.factory;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Name;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderFactoryTest {

    @Test
    void 입력_받은_이름으로_사다리를_생성_할_수_있다() {
        Ladder actual = LadderFactory.create(List.of("pobi", "honux"), 2, () -> Boolean.TRUE);
        Ladder expected = new Ladder(List.of(new Name("pobi"), new Name("honux")),
                List.of(new Line(List.of(Boolean.TRUE, Boolean.FALSE)),
                        new Line(List.of(Boolean.TRUE, Boolean.FALSE))));

        assertThat(actual).isEqualTo(expected);
    }
}
