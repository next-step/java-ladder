package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

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

    @DisplayName("generate 정적 메서드는")
    @Nested
    class Describe__generate {

        @DisplayName("사다리 게임 발판 생성 규칙에 따라, 인접한 발판이 없을 경우 발판을 생성한다.")
        @ParameterizedTest
        @CsvSource(value = {"EXIST,true,EMPTY", "EXIST,false,EMPTY", "EMPTY,true,EXIST", "EMPTY,false,EMPTY"})
        void it_returns_rung_by_strategy_value(Connection adjacent, boolean exist, Connection expectedConnection) {
            assertThat(adjacent.generate(() -> exist))
                    .isEqualTo(expectedConnection);
        }

        @DisplayName("발판 생성 규칙이 없을 경우, EMPTY를 반환한다.")
        @ParameterizedTest(name = "발판 생성 규칙이 {0}일 경우, EMPTY를 반환한다.")
        @NullSource
        void it_returns_empty_rung(RungGenerateStrategy strategy) {
            assertThat(Connection.EMPTY.generate(strategy))
                    .isEqualTo(Connection.EMPTY);
        }

    }

}
