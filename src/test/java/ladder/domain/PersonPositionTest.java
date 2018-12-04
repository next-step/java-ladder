package ladder.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonPositionTest {

    @Test
    public void 사다리게임_테스트_2X1_TRUE(){
        People people= People.from("AAA,BBB");
        Ladder ladder = Ladder.from(LadderSize.from(1, people.size()),
                width -> {
                    List<Point> points = Arrays.asList(new Point(Boolean.TRUE));
                    return LadderLine.from(points);
                });

        PersonPosition personPosition = PersonPosition.from(people, ladder);
        Map<Person, Position> personPositions = personPosition.getPersonFinalPositions();

        assertThat(personPositions.get(Person.from("AAA")).getPosition()).isEqualTo(1);
        assertThat(personPositions.get(Person.from("BBB")).getPosition()).isEqualTo(0);
    }

    @Test
    public void 사다리게임_테스트_2X1_FALSE(){
        People people= People.from("AAA,BBB");
        Ladder ladder = Ladder.from(LadderSize.from(1, people.size()),
                width -> {
                    List<Point> points = Arrays.asList(new Point(Boolean.FALSE));
                    return LadderLine.from(points);
                });

        PersonPosition personPosition = PersonPosition.from(people, ladder);
        Map<Person, Position> personPositions = personPosition.getPersonFinalPositions();

        assertThat(personPositions.get(Person.from("AAA")).getPosition()).isEqualTo(0);
        assertThat(personPositions.get(Person.from("BBB")).getPosition()).isEqualTo(1);
    }
}
