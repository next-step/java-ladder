package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class NamesTest {

    @Test
    public void 분리된이름을_생성한다() {
        Names names = new Names("test1,test2");
        assertThat(names).isEqualTo(new Names(List.of("test1", "test2")));
    }
}
