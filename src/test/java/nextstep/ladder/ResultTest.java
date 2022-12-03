package nextstep.ladder;

import nextstep.ladder.domain.Names;
import nextstep.ladder.domain.Result;
import nextstep.ladder.exception.IllegalResultInputException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResultTest {
    @Test
    void 개수_예외(){
        Assertions.assertThatThrownBy(() -> new Result("꽝,1000,꽝",new Names("sung,pobi")))
            .isInstanceOf(IllegalResultInputException.class);
    }
}
