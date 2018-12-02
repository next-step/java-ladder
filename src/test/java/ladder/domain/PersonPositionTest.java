package ladder.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonPositionTest {

    @Test
    public void 사다리게임_테스트_2X1(){
        People people= People.from("AAA,BBB");
        Ladder ladder = Ladder.from(1,people.size());
        ladder.generateLadder(a -> {
            List<Point> points = Arrays.asList(new Point(Boolean.TRUE));
            return LadderLine.from(points);
        });

        PersonPosition personPosition = PersonPosition.from(people);
        personPosition.calculateFinalPosition(ladder);

        Map<Person, Position> personPositions = personPosition.getPersonPositions();

        assertThat(personPositions.get(Person.from("AAA")).getPosition()).isEqualTo(1);
        assertThat(personPositions.get(Person.from("BBB")).getPosition()).isEqualTo(0);
    }

    @Test
    public void 사다리게임_테스트_2X2(){
        People people= People.from("AAA,BBB");
        Ladder ladder = Ladder.from(2,people.size());
        ladder.generateLadder(a -> {
            List<Point> points = Arrays.asList(new Point(Boolean.TRUE));
            return LadderLine.from(points);
        });

        PersonPosition personPosition = PersonPosition.from(people);
        personPosition.calculateFinalPosition(ladder);

        Map<Person, Position> personPositions = personPosition.getPersonPositions();

        assertThat(personPositions.get(Person.from("AAA")).getPosition()).isEqualTo(0);
        assertThat(personPositions.get(Person.from("BBB")).getPosition()).isEqualTo(1);

    }

    @Test
    public void 사다리게임_테스트_3X2(){
        People people= People.from("AAA,BBB,CCC");
        Ladder ladder = Ladder.from(2,people.size());
        ladder.generateLadder(a -> {
            List<Point> points = Arrays.asList(new Point(Boolean.TRUE),new Point(Boolean.FALSE));
            return LadderLine.from(points);
        });

        PersonPosition personPosition = PersonPosition.from(people);
        personPosition.calculateFinalPosition(ladder);

        Map<Person, Position> personPositions = personPosition.getPersonPositions();

        assertThat(personPositions.get(Person.from("AAA")).getPosition()).isEqualTo(0);
        assertThat(personPositions.get(Person.from("BBB")).getPosition()).isEqualTo(1);
        assertThat(personPositions.get(Person.from("CCC")).getPosition()).isEqualTo(2);

    }

    @Test
    public void 사다리게임_테스트_4X2(){
        People people= People.from("AAA,BBB,CCC,DDD");
        Ladder ladder = Ladder.from(2,people.size());
        ladder.generateLadder(a -> {
            List<Point> points = Arrays.asList(new Point(Boolean.TRUE),new Point(Boolean.FALSE),new Point(Boolean.TRUE));
            return LadderLine.from(points);
        });

        PersonPosition personPosition = PersonPosition.from(people);
        personPosition.calculateFinalPosition(ladder);

        Map<Person, Position> personPositions = personPosition.getPersonPositions();

        assertThat(personPositions.get(Person.from("AAA")).getPosition()).isEqualTo(0);
        assertThat(personPositions.get(Person.from("BBB")).getPosition()).isEqualTo(1);
        assertThat(personPositions.get(Person.from("CCC")).getPosition()).isEqualTo(2);
        assertThat(personPositions.get(Person.from("DDD")).getPosition()).isEqualTo(3);

    }
}
