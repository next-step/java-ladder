package ladder.domain;

import ladder.exception.NeedMoreResultValueException;
import ladder.exception.NotEqualResultValueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RewardsTest {

    @ParameterizedTest
    @CsvSource(value = {"꽝,5000,꽝,3000:3", "100,2000,5000:1"}, delimiter = ':')
    @DisplayName("게임 결과의 수와 플레이어의 수가 다르면 예외를 던진다.")
    public void NotEqualExceptionTest(String values, int playerNum) {
        Assertions.assertThrowsExactly(NotEqualResultValueException.class, () ->
                {
                    new Rewards(values, playerNum);
                }
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "꽝"})
    @DisplayName("게임 결과가 1개 이상이 아니면 예외를 던진다.")
    public void numExceptionTest(String values) {
        Assertions.assertThrowsExactly(NeedMoreResultValueException.class, () ->
                {
                    new Rewards(values);
                }
        );
    }

}