package cc.oakk.ladder.model.trace;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class TraceResultsTest {
    @ParameterizedTest
    @CsvSource(value = { "0:0", "1:2", "2:1", "3:3" }, delimiter = ':')
    public void addTraceResult_getTraceResult(int position, int finalPosition) {
        TraceResults traceResults = new TraceResults();
        traceResults.addTraceResult(Trace.of(position), Trace.of(finalPosition));
        assertThat(traceResults.getTraceResult(Trace.of(position))).isEqualTo(Trace.of(finalPosition));
    }

    @Test
    public void addTraceResult_ShouldThrow_WhenDuplicatedKey() {
        TraceResults traceResults = new TraceResults();
        traceResults.addTraceResult(Trace.of(0), Trace.of(0));
        assertThatIllegalArgumentException().isThrownBy(() -> traceResults.addTraceResult(Trace.of(0), Trace.of(1)));
    }

    @Test
    public void addTraceResult_ShouldThrow_WhenDuplicatedValue() {
        TraceResults traceResults = new TraceResults();
        traceResults.addTraceResult(Trace.of(0), Trace.of(0));
        assertThatIllegalArgumentException().isThrownBy(() -> traceResults.addTraceResult(Trace.of(1), Trace.of(0)));
    }

    @Test
    public void addTraceResult_ShouldThrow_WhenNull() {
        TraceResults traceResults = new TraceResults();
        assertThatIllegalArgumentException().isThrownBy(() -> traceResults.addTraceResult(null, Trace.of(0)));
        assertThatIllegalArgumentException().isThrownBy(() -> traceResults.addTraceResult(Trace.of(0), null));
    }

    @Test
    public void getTraceResult_ShouldThrow_WhenNonExistingKey() {
        TraceResults traceResults = new TraceResults();
        assertThatIllegalArgumentException().isThrownBy(() -> traceResults.getTraceResult(Trace.of(0)));
    }

    @Test
    public void getTraceResult_ShouldThrow_WhenNull() {
        TraceResults traceResults = new TraceResults();
        assertThatIllegalArgumentException().isThrownBy(() -> traceResults.getTraceResult(null));
    }

    @ParameterizedTest
    @CsvSource(value = { "0:0", "1:2", "2:1", "3:3" }, delimiter = ':')
    public void getDto(int position, int finalPosition) {
        TraceResults traceResults = new TraceResults();
        traceResults.addTraceResult(Trace.of(position), Trace.of(finalPosition));
        assertThat(traceResults.getDto().getTraceResult(Trace.of(position))).isEqualTo(Trace.of(finalPosition));
    }
}
