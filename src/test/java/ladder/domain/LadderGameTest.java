package ladder.domain;

import ladder.domain.dto.GameResult;
import ladder.domain.dto.Rewards;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.RandomLineGenerator;
import ladder.domain.participant.Participants;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @ParameterizedTest
    @CsvSource(value = {"3:5", "2:6", "5:3", "6:12"}, delimiter = ':')
    public void makeLadderTest(int width, int height) {
        //Given
        LadderGame game = new LadderGame(new RandomLineGenerator(), new Rewards(Arrays.asList("꽝", "3000", "50000")));

        //When
        Ladder ladder = game.makeLadder(width, height);

        //Then
        assertThat(ladder.sizeWidth()).isEqualTo(width);
        assertThat(ladder.sizeHeight()).isEqualTo(height);
    }

    @ParameterizedTest
    @MethodSource("createLines")
    public void gamePlayTest(List<Line> lines) {
        //Given
        Participants participants = Participants.of(Arrays.asList("user1", "user2", "user3", "user4", "user5"));
        Ladder ladder = new Ladder(lines);
        LadderGame game = new LadderGame(new RandomLineGenerator(), new Rewards(Arrays.asList("꽝", "3000", "50000", "2000", "1000")));

        //When
        GameResult gameResult = game.play(participants, ladder);

        //Then
        assertThat(gameResult).isNotNull();


    }
    private static Stream<Arguments> createLines() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Line(Arrays.asList(true, false, false, true)),
                        new Line(Arrays.asList(false, true, false, true)),
                        new Line(Arrays.asList(false, true, false, true)))
                )
        );
    }
}
