package cc.oakk.ladder.model.line;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ConnectionTest {
    @Test
    public void start() {
        assertThat(Connection.start(false).isLeft()).isFalse();
        assertThat(Connection.start(false).isRight()).isFalse();
        assertThat(Connection.start(true).isRight()).isTrue();
    }

    @Test
    public void next() {
        Connection connection = Connection.start(false);
        connection = connection.next(true);
        assertThat(connection.isLeft()).isFalse();
        assertThat(connection.isRight()).isTrue();

        connection = connection.next(false);
        assertThat(connection.isLeft()).isTrue();
        assertThat(connection.isRight()).isFalse();
    }

    @Test
    public void next_ShouldThrow() {
        assertThatIllegalArgumentException().isThrownBy(() -> Connection.start(true).next(true));
    }

    @ParameterizedTest
    @CsvSource(value = { "false:true:1", "true:false:-1", "false:false:0" }, delimiter = ':')
    public void move(boolean start, boolean next, int exceptedResult) {
        assertThat(Connection.start(start).next(next).move()).isEqualTo(exceptedResult);
    }
}
