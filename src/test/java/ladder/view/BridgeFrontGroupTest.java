package ladder.view;

import ladder.domain.bridge.direction.Direction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeFrontGroupTest {

    @ParameterizedTest
    @CsvSource({"LEFT,ㅓ", "RIGHT,ㅏ", "DOWN,ㅣ"})
    void findFrontByDirection(String directionName, String frontValue) {
        BridgeFrontGroup frontByDirection = BridgeFrontGroup.findFrontByDirection(Direction.valueOf(directionName));

        assertThat(frontByDirection.getFrontValue()).isEqualTo(frontValue);
    }

    @ParameterizedTest
    @CsvSource({"1,-", "2,--", "3,---"})
    void getSide(Integer length, String answer) {
        String side = BridgeFrontGroup.getSide(length);

        assertThat(side).isEqualTo(answer);
    }
}