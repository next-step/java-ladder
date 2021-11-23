package nextstep.step2.domain;

import nextstep.step2.vo.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {

    @DisplayName("연속으로 이어지는 브릿지는 만들어지지 않는다.")
    @Test
    void createTest() {

        Line actual = Line.createWithEndLine(5, () -> true);

        List<Bridge> expect = Arrays.asList(
                Bridge.RIGHT,
                Bridge.LEFT,
                Bridge.RIGHT,
                Bridge.LEFT,
                Bridge.DOWN
        );
        assertThat(actual.getBridges()).isEqualTo(expect);
    }

    @DisplayName("빈 birdge 리스트가 오면 illegal Exception")
    @Test
    void createFailTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> Line.create(null));
        assertThatIllegalArgumentException().isThrownBy(() -> Line.create(Collections.emptyList()));
    }

}
