package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ConnectionTest {

    @DisplayName("Rung은 사다리의 발판이 존재하는지 여부를 가진다.")
    @ParameterizedTest
    @CsvSource(value = {"EXIST,true", "EMPTY,false"})
    void constructor(Connection connection, boolean exist) {
        assertThat(connection.exist())
                .isEqualTo(exist);
    }

    @DisplayName("findByBoolean 메서드는 값에 따른 Rung을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"true,EXIST", "false,EMPTY"})
    void findByBoolean(boolean value, Connection connection) {
        assertThat(Connection.from(value))
                .isEqualTo(connection);
    }

}
