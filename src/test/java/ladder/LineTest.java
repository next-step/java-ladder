package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @Test
    public void 라인생성시_가로선_연속금지_테스트(){

        List<Boolean> list = new ArrayList<>();

        list.add(true);
        list.add(false);
        list.add(true);
        list.add(true);

        assertThatThrownBy(() -> {
            new Line(list);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 라인생성_테스트(){

        List<Boolean> list = new ArrayList<>();

        list.add(true);
        list.add(false);
        list.add(false);
        list.add(true);

        Line line = new Line(list);

        assertThat(line).isEqualTo(new Line(list));
    }
}
