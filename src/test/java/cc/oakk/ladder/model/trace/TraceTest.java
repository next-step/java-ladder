package cc.oakk.ladder.model.trace;

import cc.oakk.ladder.model.line.Line;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TraceTest {
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3, 4, 5, 6 })
    public void of(int position) {
        assertThat(Trace.of(position).get()).isEqualTo(position);
        assertThat(Trace.of(position)).isEqualTo(Trace.of(position));
    }

    @ParameterizedTest
    @CsvSource(value = { "2:1", "1:2", "3:3" }, delimiter = ':')
    public void move(int position, int exceptedPosition) {
        Line line = new Line(5).connect(1);
        assertThat(Trace.of(position).move(line)).isEqualTo(Trace.of(exceptedPosition));
    }
}
