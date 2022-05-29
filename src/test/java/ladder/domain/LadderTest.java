package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("입력 받은 사람수, 움직이는 횟수에 맞춰 Ladder 객체 생성")
    @ParameterizedTest
    @CsvSource(value = {"4:5:5"}, delimiter = ':')
    void create(int countOfPerson, int numberOfMoves, int expected) {
        ConnectingStrategy connectingStrategy = new SequentialConnectionStratrgy();
        Ladder ladder = new Ladder(countOfPerson, numberOfMoves, connectingStrategy);
        assertThat(ladder.getVerticalLines()).hasSize(expected);
    }
}
