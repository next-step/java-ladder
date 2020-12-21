package ladder.domain.ladder;

import ladder.domain.participant.Participant;
import ladder.domain.participant.Participants;
import ladder.domain.support.LineBuilder;
import ladder.exception.InsufficientLadderHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest extends LineBuilder {

    @Test
    public void createInstanceTest() {
        //Given & When
        List<Line> lines = createRandomLinesBuild(3,5);
        Ladder ladder = new Ladder(lines);

        //Then
        assertThat(ladder).isNotNull();
        assertThat(ladder.sizeHeight()).isEqualTo(lines.size());
    }

    @DisplayName("높이가 2 미만일 경우 예외처리 테스트")
    @Test
    public void insufficientLadderHeightTest() {
        assertThatThrownBy(() ->
                new Ladder(createRandomLinesBuild(1,1))
        ).isInstanceOf(InsufficientLadderHeightException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    public void getLineTest(int index) {
        //Given
        int size = 5;
        Ladder ladder = new Ladder(createRandomLinesBuild(size,5));

        //When
        List<Boolean> line = ladder.getLine(index);

        //Then
        assertThat(line).hasSize(size);
    }

    @Test
    public void movePositionTest() {
        //Given
        int height = 5;
        Participants participants = Participants.of(Arrays.asList("user", "user2", "user3", "user4"));
        Ladder ladder = new Ladder(createRandomLinesBuild(height, participants.countParticipant()));

        //When
        IntStream.range(0, height).forEach(i -> ladder.movePosition(i, participants));

        //Then
        assertThat(participants.getParticipant(0)).isNotEqualTo(new Participant("user", 0));
    }
}
