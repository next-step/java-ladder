package nextstep.step2.domain;

import nextstep.step2.vo.Gift;
import nextstep.step2.vo.Gifts;
import nextstep.step2.vo.Name;
import nextstep.step2.vo.Names;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameInfoTest {

    private GameInfo gameInfo;

    @BeforeEach
    void setUp() {
        gameInfo = GameInfo.of(Names.fromWithString("miz,kk,yy"), Gifts.fromWithString("1000,2000,3000"));
    }

    @Test
    void createTest() {
        GameInfo gameInfo = GameInfo.of(Names.fromWithString("miz,bi"), Gifts.fromWithString("1000,2000"));

        assertThat(gameInfo).isEqualTo(GameInfo.of(Names.fromWithString("miz,bi"), Gifts.fromWithString("1000,2000")));
    }

    @DisplayName("Names와 Gifts의 사이즈가 다르면 illegal exception")
    @Test
    void createFailTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> GameInfo.of(Names.fromWithString("miz,bi"), Gifts.fromWithString("1,2,3")));
    }

    @DisplayName("사람 이름으로 Optional<Point> 를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"miz:0", "kk:1", "yy:2"}, delimiter = ':')
    void findStartPointTest(String name, int expectPoint) {
        Point startPoint = gameInfo.findStartPoint(Name.from(name)).get();

        assertThat(startPoint).isEqualTo(Point.from(expectPoint));
    }

    @DisplayName("없는 참가자일 경우 Optional.empty를 반환한다.")
    @Test
    void findStartPointEmptyTest() {
        assertThat(gameInfo.findStartPoint(Name.from("yo"))).isEqualTo(Optional.empty());
    }

    @DisplayName("포인트 값으로 Gift 를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"0:1000", "1:2000", "2:3000"}, delimiter = ':')
    void findGiftWithPointTest(int expectPoint, String giftName) {
        Gift gift = gameInfo.findGiftWithPoint(Point.from(expectPoint));

        assertThat(gift).isEqualTo(Gift.from(giftName));
    }

    @DisplayName("포인트가 범위를 벗어날 경우 illegal exception")
    @Test
    void findGiftWithPointFailTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> gameInfo.findGiftWithPoint(Point.from(3)));
    }

}
