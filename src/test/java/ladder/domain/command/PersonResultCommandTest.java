package ladder.domain.command;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.element.Persons;
import ladder.domain.element.Prize;
import ladder.domain.element.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonResultCommandTest {

    @Test
    @DisplayName("command match test")
    void testCommandMatch() {
        Persons persons = Persons.fromText("pobi");
        assertThat(new PersonResultCommand().match(persons, "pobi")).isTrue();
    }

    @Test
    @DisplayName("특정 사람 결과 추출")
    void testShowPersonResult() {
        // given
        Persons persons = Persons.fromText("pobi,honux");
        Prizes prizes = Prizes.fromText("1,2");
        Ladder ladder = new Ladder(persons, 1, (index, indexConsumer) -> indexConsumer.accept(index));
        LadderGame ladderGame = new LadderGame(persons, ladder, prizes);
        // when
        Prize prize = new PersonResultCommand().showResult(ladderGame, "pobi");
        // then
        assertThat(prize).isEqualTo(prizes.get(1));
    }
}
