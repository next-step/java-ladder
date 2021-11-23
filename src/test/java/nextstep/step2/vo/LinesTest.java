package nextstep.step2.vo;

import nextstep.step2.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LinesTest {

    @DisplayName("Null or Empty input illegal exception")
    @Test
    void nullOrEmptyTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lines.create(null));
        assertThatIllegalArgumentException().isThrownBy(() -> Lines.create(Collections.emptyList()));
    }

    @DisplayName("정상 생성 테스트")
    @Test
    void createTEst() {
        assertThat(Lines.create(Arrays.asList(Line.createWithEndLine(2,()->true))))
                .isEqualTo(Lines.create(Arrays.asList(Line.createWithEndLine(2,()->true))));
    }


}
