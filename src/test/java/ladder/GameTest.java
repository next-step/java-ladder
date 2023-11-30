package ladder;

import ladder.domain.Game;
import ladder.domain.Line;
import ladder.domain.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void Game_사다리_생성() {
        List<Person> personList = Arrays.asList(new Person("p1"), new Person("p2"), new Person("p3"));
        int ladderHeight = 5;
        Game game = new Game(personList, ladderHeight);
        List<Line> lines = game.ladderLines();

        assertThat(lines.size()).isEqualTo(5);
    }
}