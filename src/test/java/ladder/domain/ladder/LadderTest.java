package ladder.domain.ladder;

import ladder.domain.participant.Participant;
import ladder.domain.participant.Participants;
import ladder.exception.InsufficientLadderHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @Test
    public void createInstanceTest() {
        //Given & When
        List<Line> lines = Arrays.asList(new Line(Arrays.asList(true, false, false)), new Line(Arrays.asList(true,false,false)));
        Ladder ladder = new Ladder(lines);

        //Then
        assertThat(ladder).isNotNull();
        assertThat(ladder.sizeHeight()).isEqualTo(lines.size());
    }

    @DisplayName("높이가 2 미만일 경우 예외처리 테스트")
    @Test
    public void insufficientLadderHeightTest() {
        assertThatThrownBy(() ->
                new Ladder(Arrays.asList(new Line(Arrays.asList(true, false))))
        ).isInstanceOf(InsufficientLadderHeightException.class);
    }

    @Test
    public void getLineTest() {
        //Given
        int index = 0;
        List<Boolean> expected = Arrays.asList(true, false, false, true);
        Ladder ladder = new Ladder(Arrays.asList(new Line(expected), new Line(expected)));

        //When
        List<Boolean> line = ladder.getLine(index);

        //Then
        assertThat(line).hasSize(expected.size());
    }

    @ParameterizedTest
    @MethodSource("createLines")
    public void movePositionTest(List<Line> lines) {
        //Given
        Participants participants = Participants.of(Arrays.asList("user", "user2", "user3", "user4", "user5"));
        Ladder ladder = new Ladder(lines);

        //When
        ladder.movePosition(1, participants);

        //Then
        assertThat(participants.getParticipant(0)).isNotEqualTo(new Participant("user", 0));
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
