package nextstep.ladder.model;

import nextstep.ladder.factory.LineFactory;
import nextstep.ladder.generator.LineRandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.model.Line.BLANK_LINE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {


    @Test
    @DisplayName("이전 다리가 있을 경우, 다음 다리는 무조건 없음 ")
    void beforeTrueThenFalse() {
        LineRandomGenerator generator = new LineRandomGenerator();
        Line line = LineFactory.of(Boolean.TRUE, 4, generator);

        List<String> lines = line.getPoints().stream()
                .map(Point::isActive)
                .map(Line::isLine)
                .collect(Collectors.toList());

        assertThat(lines.get(1)).isEqualTo(BLANK_LINE);

    }

    @Test
    @DisplayName("인접한 다리가 있을 경우 IllegalArgumentException 발생")
    void validationAdjacentPoint() {
        assertThatIllegalArgumentException().isThrownBy(() -> LineFactory.of(Boolean.TRUE, 4, (prev) -> true));
    }


    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,0", "2,3", "3,2"})
    @DisplayName("Line에서 Player 이동 테스트")
    void moveTest(int index, int output) {
        Player player = new Player("test", index);
        Line line = LineFactory.of(true, 4, prev -> !prev); // |-----|     |-----|
        line.move(player);

        assertThat(player.getIndex()).isEqualTo(new Index(output));
    }
}