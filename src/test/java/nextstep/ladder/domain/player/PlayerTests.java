package nextstep.ladder.domain.player;

import nextstep.ladder.domain.exceptions.PlayerNameEmptyException;
import nextstep.ladder.domain.exceptions.PlayerNameLengthException;
import nextstep.ladder.domain.ladder.HorizontalLocation;
import nextstep.ladder.domain.ladder.HorizontalMoveStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTests {
    private HorizontalLocation horizontalLocation;

    @BeforeEach
    public void setup() {
        horizontalLocation = new HorizontalLocation(0, 5);
    }

    @DisplayName("이름과 현재 위치값을 전달받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        Player player = new Player("poppo", horizontalLocation);
        assertThat(player).isNotNull();
    }

    @DisplayName("5 글자를 넘는 값으로 객체를 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"thisistoolong", "666666"})
    void createLengthValidationTest(String invalidNameValue) {
        assertThatThrownBy(() -> new Player(invalidNameValue, horizontalLocation))
                .isInstanceOf(PlayerNameLengthException.class);
    }

    @DisplayName("null이나 길이가 0이거나 빈 문자열로는 객체를 생성할 수 없다.")
    @NullSource
    @ParameterizedTest
    @ValueSource(strings = {"", "     "})
    void createEmptyValidationTest(String invalidNameValue) {
        assertThatThrownBy(() -> new Player(invalidNameValue, horizontalLocation))
                .isInstanceOf(PlayerNameEmptyException.class);
    }

    @DisplayName("전달받은 HorizontalMoveStrategy에 따라 움직일 수 있다.")
    @ParameterizedTest
    @MethodSource("moveStrategies")
    void moveTest(HorizontalLocation initHorizontalLocation, HorizontalMoveStrategy horizontalMoveStrategy,
                  HorizontalLocation expectedLocation) {
        Player player = new Player("poppo", initHorizontalLocation);
        HorizontalLocation horizontalLocationAfterMove = player.move(horizontalMoveStrategy);
        assertThat(horizontalLocationAfterMove).isEqualTo(expectedLocation);
    }
    public static Stream<Arguments> moveStrategies() {
        return Stream.of(
                Arguments.of(new HorizontalLocation(0, 5), HorizontalMoveStrategy.STAY,
                        new HorizontalLocation(0, 5)),
                Arguments.of(new HorizontalLocation(0, 5), HorizontalMoveStrategy.MOVE_RIGHT,
                        new HorizontalLocation(1, 5)),
                Arguments.of(new HorizontalLocation(1, 5), HorizontalMoveStrategy.MOVE_LEFT,
                        new HorizontalLocation(0, 5))
        );
    }
}
