package ladder.entity.ladderMap;

import ladder.entity.participant.ParticipantList;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c,d,e", "a"})
    void canGenerateLine(String input){
        ParticipantList participantList = new ParticipantList(input);
        Line line = new Line(participantList);
        verifyLine(line);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c,d,e", "a"})
    void canTellMovedPoints(String input){
        ParticipantList participantList = new ParticipantList(input);
        Line line = new Line(participantList);

        HashSet<Point> set = new HashSet<>();
        for(Point point: line.points()){
            set.add(line.traverseLinks(point));
        }
        assertThat(set.size()).isEqualTo(participantList.size());
    }

    void verifyLine(Line line){
        List<Link> links = line.links();
        SoftAssertions softAssertions = new SoftAssertions();
        for(int index = 0;index<links.size()-1;index++){
            Link preLink = links.get(index);
            Link curLink = links.get(index+1);
            softAssertions.assertThat(preRightThanCurLeft(preLink, curLink)).isTrue();
        }
        softAssertions.assertAll();
    }

    private boolean preRightThanCurLeft(Link preLink, Link curLink){
        if(preLink.goesRight()){
            return curLink.goesLeft();
        }
        return true;
    }
}
