package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 2, 5})
    @DisplayName("높이만큼 line 개수와 참가자 수 만큼의 point 개수를 가진 사다리 생성 ")
    void createLadderTest(int height) {
        // given
        LadderGenerator ladderGenerator = new LadderGenerator(() -> true);
        Participants participants = new Participants(List.of(
                new Participant("a"),
                new Participant("b"),
                new Participant("c"),
                new Participant("d"),
                new Participant("e")
        ));
        Ladder ladder = ladderGenerator.createLadder(participants.size(), height);
        // when
        List<Line> lines = ladder.getLines();
        // then
        assertThat(lines).hasSize(height);
        for (Line line : lines) {
            assertThat(line.getPoints().size()).isEqualTo(participants.getParticipants().size());
        }
    }
    

}