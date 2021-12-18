package nextstep.ladder.step4.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.step4.domain.ladder.strategy.RandomLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    @DisplayName("사다리 생성")
    void create(int width) {
        List<DefaultLine> lines = new ArrayList<>();
        lines.add(new DefaultLineGenerator(new RandomLineStrategy()).generate(width));

        assertThat(new DefaultLadder(lines)).isInstanceOf(DefaultLadder.class);
    }

    @Test
    @DisplayName("lines 가 비어있을 시 예외처리")
    void exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new DefaultLadder(new ArrayList<>()));
    }

}
