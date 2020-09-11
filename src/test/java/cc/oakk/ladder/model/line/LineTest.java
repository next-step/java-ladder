package cc.oakk.ladder.model.line;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {
    @Test
    public void constructor_ShouldThrow_WhenBelowsOrEqualsZero() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(0));
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(-1));
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(Integer.MIN_VALUE));
    }

    @ParameterizedTest
    @ValueSource(ints = { 4, 5, 6, 7, 8 })
    public void width(int width) {
        assertThat(new Line(width).width()).isEqualTo(width);
    }

    @Test
    public void connect() {
        final Line line = new Line(6);
        assertThat(line.isConnected(0)).isEqualTo(false);
        line.connect(0);
        assertThat(line.isConnected(0)).isEqualTo(true);

        line.connect(2, 4);
        assertThat(line.isConnected(2)).isEqualTo(true);
        assertThat(line.isConnected(4)).isEqualTo(true);
    }

    @Test
    public void connect_ShouldThrow() {
        final Line line = new Line(4);
        line.connect(0);
        assertThatIllegalArgumentException().isThrownBy(() -> line.connect(1));
        assertThatIllegalArgumentException().isThrownBy(() -> line.connect(3));
    }
}