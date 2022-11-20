package nextstep.ladder;

import nextstep.ladder.domain.Name;
import nextstep.ladder.exception.IllegalNameLengthException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    void 이름은_5자_제한() {
        String name = "ThisNameIsOver5";
        Assertions.assertThatThrownBy(() -> new Name(name))
            .isInstanceOf(IllegalNameLengthException.class);
    }
}
