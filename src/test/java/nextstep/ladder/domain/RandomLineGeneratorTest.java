package nextstep.ladder.domain;

import nextstep.ladder.exception.LineRowException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomLineGeneratorTest {
    private LineGenerator generator = new RandomLineGenerator();

    @Test
    @DisplayName("입력받은 List<Boolean>을 통해 Line을 생성한다")
    void create() {
        List<Boolean> list = Arrays.asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE);

        assertThat(generator.generate(list)).isInstanceOf(Line.class);
    }

    @Test
    @DisplayName("생성된 Line의 size는 입력 받는 List<Boolean>의 size + 1로 생성 된다")
    void size() {
        List<Boolean> list = Arrays.asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE);
        Line line = generator.generate(list);

        assertThat(line.getLine().size()).isEqualTo(list.size() + 1);
    }

    @ParameterizedTest
    @DisplayName("Line을 생성하기 위해서 최소 1개 이상의 List<Boolean>이 필요하다")
    @EmptySource
    void exception(List<Boolean> list) {
        assertThatThrownBy(() -> generator.generate(list)).isInstanceOf(LineRowException.class);
    }
}