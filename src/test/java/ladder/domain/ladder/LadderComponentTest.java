package ladder.domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderComponentTest {

    @Test
    @DisplayName("높이, 넓이를 가지는 객체 생성")
    void create() {
        LadderComponent component = LadderComponent.of(4, 5);
        Assertions.assertThat(component).isEqualTo(LadderComponent.of(4, 5));
    }

}