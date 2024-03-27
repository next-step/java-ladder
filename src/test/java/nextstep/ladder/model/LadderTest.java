package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("참가자 수와 높이 값을 입력받아 Ladder 생성한다")
    @Test
    void of() {
        int height = 2;
        int countOfPerson = 4;

        Ladder ladder = Ladder.of(height, countOfPerson);
        assertThat(ladder.height()).isEqualTo(height);
    }

    @DisplayName("Line 입력받아 Ladder 생성한다")
    @Test
    void from() {
        Line line1 = Line.from(3);
        Line line2 = Line.from(3);
        Line line3 = Line.from(3);

        Ladder ladder = Ladder.from(line1, line2, line3);

        assertThat(ladder)
                .isEqualTo(Ladder.from(line1, line2, line3));
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:1", "2:2", "3:3"}, delimiter = ':')
    void 라인이_연결되지_않은경우_시작과_동일한_객체를_반환한다(int start, int expected) {
        Player player = new Player("test", start);

        Line line1 = LineTestUtil.createLineBy(false, false, false);
        Line line2 = LineTestUtil.createLineBy(false, false, false);

        Ladder ladder = Ladder.from(line1, line2);
        ladder.move(player);

        assertThat(player).isEqualTo(new Player("test", expected));
    }

    /**
     * |-----|     |-----|
     * |     |-----|     |
     */
    @ParameterizedTest
    @CsvSource(value = {"0:2", "1:0", "2:3", "3:1"}, delimiter = ':')
    void 라인이_연결되어_있는경우_이동한_결과객체를_반환한다(int start, int expected) {
        Player player = new Player("test", start);

        Line line1 = LineTestUtil.createLineBy(true, false, true);
        Line line2 = LineTestUtil.createLineBy(false, true, false);
        Ladder ladder = Ladder.from(line1, line2);
        ladder.move(player);

        assertThat(player).isEqualTo(new Player("test", expected));
    }

}
