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

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class StairsTest {
    @DisplayName("여러 계단을 가진 일급 객체를 생성할 수 있다.")
    @Test
    void create() {
        int count = 3;
        Stairs stairs = new Stairs(new FakeThreeByOneLeftLineGenerator().generate(count));

        assertThat(stairs.count()).isEqualTo(3);
    }

    @DisplayName("계단이 존재하지 않으면 참여자 시작위치를 그대로 반환한다.")
    @Test
    void moveOneByZero() {
        int playerStartPosition = 0;
        Position expect = new Position(playerStartPosition);

        Stairs stairs = new Stairs(Arrays.asList(new Stair().first()));
        Position position = stairs.move(new Position(playerStartPosition));

        assertThat(position).isEqualTo(expect);
    }

    @DisplayName("참여자 2명, 계단이 존재하지 않으면 참여자 시작위치를 그대로 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void moveTwoByZero(int playerStartPosition) {
        int playerCount = 2;
        Stairs stairs = new Stairs(new FakeTwoByZeroLineGenerator().generate(playerCount));

        Position position = stairs.move(new Position(playerStartPosition));

        assertThat(position).isEqualTo(new Position(playerStartPosition));
    }

    @DisplayName("참여자 2명, 계단이 1개 존재하면 참여자 시작위치를 서로 교환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0"}, delimiter = ':')
    void moveTwoByOne(int playerStartPosition, int expect) {
        int playerCount = 2;
        Stairs stairs = new Stairs(new FakeTwoByOneLineGenerator().generate(playerCount));

        Position position = stairs.move(new Position(playerStartPosition));

        assertThat(position).isEqualTo(new Position(expect));
    }

    @DisplayName("참여자 3명, 계단이 왼쪽에 1개 존재하면 참여자 시작위치를 서로 교환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:2"}, delimiter = ':')
    void moveThreeByOneLeft(int playerStartPosition, int expect) {
        int playerCount = 3;
        Stairs stairs = new Stairs(new FakeThreeByOneLeftLineGenerator().generate(playerCount));

        Position position = stairs.move(new Position(playerStartPosition));

        assertThat(position).isEqualTo(new Position(expect));
    }

    @DisplayName("참여자 3명, 계단이 오른쪽에 1개 존재하면 참여자 시작위치를 서로 교환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:2", "2:1"}, delimiter = ':')
    void moveThreeByOneRight(int playerStartPosition, int expect) {
        int playerCount = 3;
        Stairs stairs = new Stairs(new FakeThreeByOneRightLineGenerator().generate(playerCount));

        Position position = stairs.move(new Position(playerStartPosition));

        assertThat(position).isEqualTo(new Position(expect));
    }
}