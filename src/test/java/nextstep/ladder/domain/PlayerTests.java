package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.PlayerNameEmptyException;
import nextstep.ladder.domain.exceptions.PlayerNameLengthException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("오른쪽으로 이동 시 현재 Location을 1 증가시킨다.")
    @Test
    void moveRightTest() {
        Player player = new Player("poppo", horizontalLocation);

        player.moveRight();

        assertThat(player).isEqualTo(new Player("poppo",
                new HorizontalLocation(1, 5)));
    }

    @DisplayName("왼쪽으로 이동 시 현재 Location을 1 감소시킨다.")
    @Test
    void moveLeftTest() {
        int initLocationValue = 1;
        int countOfPerson = 5;
        Player player = new Player("poppo",  new HorizontalLocation(initLocationValue, countOfPerson));

        player.moveLeft();

        assertThat(player).isEqualTo(new Player("poppo",
                new HorizontalLocation(0, 5)));
    }
}
