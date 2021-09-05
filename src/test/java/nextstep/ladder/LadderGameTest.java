package nextstep.ladder;

import nextstep.ladder.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestInstance(Lifecycle.PER_CLASS)
public class LadderGameTest {
    private Ladder ladder;
    private List<Person> people;

    @BeforeAll
    public void initLadder() {
        Line firstLine = new Line(3);
        Line secondLine = new Line(3);
        Line thirdLine = new Line(3);

        List<Point> firstPoints = firstLine.getPoints();
        List<Point> secondPoints = secondLine.getPoints();
        List<Point> thirdPoints = thirdLine.getPoints();

        firstPoints.get(0)
                .use(1);
        secondPoints.get(0)
                .use(0);

        secondPoints.get(1)
                .use(2);
        thirdPoints.get(1)
                .use(1);

        firstPoints.get(2)
                .use(1);
        secondPoints.get(2)
                .use(0);

        List<Line> lines = Arrays.asList(firstLine, secondLine, thirdLine);
        List<Reward> rewards = Arrays.asList(new Reward("1"), new Reward("2"), new Reward("3"));
        ladder = new Ladder(lines, rewards);
        people = Arrays.asList(new Person("1"), new Person("2"), new Person("3"));
    }

    @ParameterizedTest
    @CsvSource({"1,3", "2,2", "3,1"})
    public void runTest(String start, String rewardValue) {
        //when
        Reward reward = ladder.doPlay(people.indexOf(new Person(start)));

        //then
        assertThat(reward).isEqualTo(new Reward(rewardValue));
    }

}