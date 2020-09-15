package cc.oakk.ladder.model.ladder;

import cc.oakk.ladder.model.ladder.dto.LadderDto;
import cc.oakk.ladder.model.line.Line;
import cc.oakk.ladder.model.trace.Trace;
import cc.oakk.ladder.model.trace.TraceResults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    Ladder ladder;

    @ParameterizedTest
    @ValueSource(ints = { 0, -1, Integer.MIN_VALUE })
    public void constructor_ShouldThrow_WhenBelowsOrEqualsZero(int height) {
        assertThatIllegalArgumentException().isThrownBy(() -> Ladder.of(height, new LadderInitializer(2, (w, h) -> new boolean[1])));
    }

    @BeforeEach
    public void beforeEach() {
        ladder = Ladder.of(5, new LadderInitializer(5, (w, h) -> new boolean[] { false, true, false, true }));
    }

    @Test
    public void getDto() {
        Line comparingLine = Line.of(false, true, false, true);
        LadderDto ladderDto = new LadderDto(IntStream.range(0, 5).boxed()
                .map(v -> comparingLine.getDto())
                .collect(Collectors.toList()));

        assertThat(ladder.getDto()).isEqualTo(ladderDto);
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 3, 4, 5, 6 })
    public void width(int width) {
        assertThat(Ladder.of(1, new LadderInitializer(width, (w, h) -> new boolean[width - 1])).width()).isEqualTo(width);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6 })
    public void height(int height) {
        assertThat(Ladder.of(height, new LadderInitializer(2, (w, h) -> new boolean[1])).height()).isEqualTo(height);
    }

    @ParameterizedTest
    @CsvSource(value = { "0:0", "1:2", "2:1", "3:4", "4:3" }, delimiter = ':')
    public void trace(int position, int exceptedPosition) {
        assertThat(ladder.trace(Trace.of(position))).isEqualTo(Trace.of(exceptedPosition));
    }

    @Test
    public void traceAll() {
        TraceResults traceResults = ladder.traceAll();
        assertThat(traceResults.getTraceResult(Trace.of(0))).isEqualTo(Trace.of(0));
        assertThat(traceResults.getTraceResult(Trace.of(1))).isEqualTo(Trace.of(2));
        assertThat(traceResults.getTraceResult(Trace.of(2))).isEqualTo(Trace.of(1));
        assertThat(traceResults.getTraceResult(Trace.of(3))).isEqualTo(Trace.of(4));
        assertThat(traceResults.getTraceResult(Trace.of(4))).isEqualTo(Trace.of(3));
    }
}
