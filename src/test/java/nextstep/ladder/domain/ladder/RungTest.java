package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RungTest {

    @DisplayName("Rung은 사다리의 발판이 존재하는지 여부를 가진다.")
    @ParameterizedTest
    @CsvSource(value = {"EXIST,true", "EMPTY,false"})
    void constructor(Rung rung, boolean exist) {
        assertThat(rung.exist())
                .isEqualTo(exist);
    }


    @DisplayName("generate 메서드는")
    @Nested
    class Describe_generate {

        @DisplayName("사다리 게임 발판 생성 규칙에 따라, 발판을 생성한다.")
        @ParameterizedTest
        @CsvSource(value = {"true,EXIST", "false,EMPTY"})
        void it_returns_rung_by_strategy_value(boolean exist, Rung expectedRung) {
            assertThat(Rung.generate(() -> exist))
                    .isEqualTo(expectedRung);
        }

        @DisplayName("발판 생성 규칙이 없을 경우, EMPTY를 반환한다.")
        @ParameterizedTest(name = "발판 생성 규칙이 {0}일 경우, EMPTY를 반환한다.")
        @NullSource
        void it_returns_empty_rung(RungGenerateStrategy strategy) {
            assertThat(Rung.generate(strategy))
                    .isEqualTo(Rung.EMPTY);
        }

    }

}
