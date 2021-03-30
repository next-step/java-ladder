package ladder.entity.ladderMap;

import ladder.entity.participant.ParticipantList;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LadderMapTest {

    @ParameterizedTest
    @CsvSource(value = {"a,b,c,d,e:2"}, delimiter = ':')
    void canGenerateLadderMap(String participantString, int height){
        ParticipantList participantList = new ParticipantList(participantString);
        LadderHeight ladderHeight = new LadderHeight(height);
        LadderMap ladderMap = new LadderMap(participantList, ladderHeight);

        LineTest lineTest = new LineTest();
        for(Line line: ladderMap.lines()){
            lineTest.verifyLine(line);
        }
    }
}
