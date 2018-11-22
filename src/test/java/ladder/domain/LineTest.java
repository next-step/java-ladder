package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void 생성() {
        Line line = Line.create(5);
        assertThat(line).isNotNull();
        assertThat(line.size()).isEqualTo(5);
    }

    @Test
    public void 연결() {
        Line line = Line.create(5);
        Connection connection = line.draw(1);
        assertThat(connection.isConnected()).isTrue();

    }

    @Test
    public void 연결_불가() {
        Line line = Line.create(5);
        Connection connection = line.draw(4);
        assertThat(connection.isConnected()).isFalse();
    }
}
