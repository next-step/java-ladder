package ladder.domain;

import ladder.domain.fake.FakeThreeByOneLeftLineGenerator;
import ladder.domain.fake.FakeThreeByOneRightLineGenerator;
import ladder.domain.fake.FakeTwoByOneLineGenerator;
import ladder.domain.fake.FakeTwoByZeroLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("참여자가 1명이라면 라인을 생성할 수 없다.")
    @Test
    void createLine_OnePlayer() {
        int playerCount = 1;
        Line line = Line.of(playerCount);

        List<Stair> actual = line.getLine();

        assertThat(actual.get(0)).isEqualTo(new Stair(false));
    }

    @DisplayName("참여자 1명, 라인이 존재하지 않으면 참여자 시작위치를 그대로 반환한다.")
    @Test
    void moveOneByZero() {
        int playerCount = 1;
        int playerStartPosition = 0;
        Position expect = new Position(playerStartPosition);
        Line line = Line.of(playerCount);

        Position position = line.move(new Position(playerStartPosition));

        assertThat(position).isEqualTo(expect);
    }

    @DisplayName("참여자 2명, 라인이 존재하지 않으면 참여자 시작위치를 그대로 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void moveTwoByZero(int playerStartPosition) {
        int playerCount = 2;
        Line line = Line.of(playerCount, new FakeTwoByZeroLineGenerator());

        Position position = line.move(new Position(playerStartPosition));

        assertThat(position).isEqualTo(new Position(playerStartPosition));
    }

    @DisplayName("참여자 2명, 라인이 1개 존재하면 참여자 시작위치를 서로 교환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0"}, delimiter = ':')
    void moveTwoByOne(int playerStartPosition, int expect) {
        int playerCount = 2;
        Line line = Line.of(playerCount, new FakeTwoByOneLineGenerator());

        Position position = line.move(new Position(playerStartPosition));

        assertThat(position).isEqualTo(new Position(expect));
    }

    @DisplayName("참여자 3명, 라인이 왼쪽에 1개 존재하면 참여자 시작위치를 서로 교환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:2"}, delimiter = ':')
    void moveThreeByOneLeft(int playerStartPosition, int expect) {
        int playerCount = 3;
        Line line = Line.of(playerCount, new FakeThreeByOneLeftLineGenerator());

        Position position = line.move(new Position(playerStartPosition));

        assertThat(position).isEqualTo(new Position(expect));
    }

    @DisplayName("참여자 3명, 라인이 오른쪽에 1개 존재하면 참여자 시작위치를 서로 교환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:2", "2:1"}, delimiter = ':')
    void moveThreeByOneRight(int playerStartPosition, int expect) {
        int playerCount = 3;
        Line line = Line.of(playerCount, new FakeThreeByOneRightLineGenerator());

        Position position = line.move(new Position(playerStartPosition));

        assertThat(position).isEqualTo(new Position(expect));
    }
}