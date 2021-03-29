package ladder.domain.ladderMap;

import ladder.domain.participant.ParticipantList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @ParameterizedTest
    @CsvSource(value = {
            "a,b,c,d,e:5",
            "A, b, C ,d:4",
            "a,aa,aaa,aaaa,aaaaa:5"}, delimiter = ':')
    @DisplayName("참가자들의 이름의 수와 점의 수가 일치한다")
    void generatesValidNumberOfPoints(String inputString, int expected) {
        ParticipantList participantList = new ParticipantList(inputString);
        Line line = new Line(participantList);
        assertThat(line.points().size()).isEqualTo(expected);
    }

}
