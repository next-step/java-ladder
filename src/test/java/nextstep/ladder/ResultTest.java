package nextstep.ladder;

import nextstep.ladder.domain.Result;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ResultTest {

    @Test
    void create() {
        Result result = new Result("꽝,5000,꽝,3000");
        assertThat(result.size()).isEqualTo(4);
    }

    @Test
    void create2() {
        Result result = new Result(" 꽝 , 5000  , 꽝  , 3000 ");
        assertAll(
                () -> assertThat(result.get(0)).isEqualTo("꽝"),
                () -> assertThat(result.get(1)).isEqualTo("5000"),
                () -> assertThat(result.get(2)).isEqualTo("꽝"),
                () -> assertThat(result.get(3)).isEqualTo("3000")
        );

    }
}
