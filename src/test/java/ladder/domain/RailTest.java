package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RailTest {

    @DisplayName("Rail은 LadderPart의 구현체")
    @Test
    void create() {
        Assertions.assertThat(Rail.instance()).isInstanceOf(LadderPart.class);
    }

    @DisplayName("Rail의 value 확인")
    @Test
    void value() {
        assertThat(Rail.instance().value()).isEqualTo("|");
    }

}
