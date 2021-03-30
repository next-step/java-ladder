package ladder.entity.ladderMap;

import ladder.entity.participant.ParticipantList;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class LineTest {

    /*

    private final List<Point> points;
    private final List<Link> links;

    public Line(ParticipantList participantList) {
        this.points = points(participantList);
        this.links = links(points);
    }

     */

    @ParameterizedTest
    @ValueSource(strings = "a,b,c,d,e")
    void canGenerateLine(String input){
        ParticipantList participantList = new ParticipantList(input);
        Line line = new Line(participantList);
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
