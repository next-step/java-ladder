package ladder;

import ladder.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void Game_사다리_생성() {
        PersonList personList = new PersonList(Arrays.asList(new Person("p1", 0),
                new Person("p2", 1), new Person("p3", 2)));
        int ladderHeight = 5;
        Game game = new Game(personList, ladderHeight);
        List<Line> lines = game.ladderLines();

        assertThat(lines.size()).isEqualTo(5);
    }

    @Test
    void 결과_계산_1() {
        PersonList personList = new PersonList(Arrays.asList(new Person("p1", 0), new Person("p2", 1)));
        List<LineCondition> conditions = List.of(() -> true, () -> true, () -> true);
        Game game = new Game(personList, conditions);
        game.playGame();
        List<Person> persons = personList.getPersonList();

        assertThat(persons.get(0).getPosition()).isEqualTo(1);
        assertThat(persons.get(1).getPosition()).isEqualTo(0);
    }

    @Test
    void 결과_계산_2() {
        PersonList personList = new PersonList(Arrays.asList(new Person("p1", 0), new Person("p2", 1)));
        List<LineCondition> conditions = List.of(() -> true, () -> true);
        Game game = new Game(personList, conditions);
        game.playGame();
        List<Person> persons = personList.getPersonList();

        assertThat(persons.get(0).getPosition()).isEqualTo(0);
        assertThat(persons.get(1).getPosition()).isEqualTo(1);
    }
}