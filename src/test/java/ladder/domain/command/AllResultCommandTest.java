package ladder.domain.command;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.element.LadderPrize;
import ladder.domain.element.LadderPrizes;
import ladder.domain.element.Persons;
import ladder.domain.element.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AllResultCommandTest {

    @Test
    @DisplayName("command match test")
    void testCommandMatch() {
        assertThat(new AllResultCommand().match("all")).isTrue();
        assertThat(new AllResultCommand().match("alll")).isFalse();
    }

    @Test
    @DisplayName("전체 결과 추출")
    void testShowPersonResult() {
        // given
        Persons persons = Persons.fromText("a,b");
        Prizes prizes = Prizes.fromText("1,2");
        Map<String, String> prizeMap = new HashMap<>();
        prizeMap.put("a", "2");
        prizeMap.put("b", "1");

        Ladder ladder = new Ladder(persons, 1, (index, indexConsumer) -> indexConsumer.accept(index));
        LadderGame ladderGame = new LadderGame(persons, ladder, prizes);
        // when
        LadderPrizes ladderPrizes = new AllResultCommand().showResult(ladderGame, "a");
        // then
        for (LadderPrize ladderPrize : ladderPrizes) {
            Persons.Person person = ladderPrize.getPerson();
            assertThat(ladderPrize.getPrize().getName()).isEqualTo(prizeMap.get(person.getName()));
        }
    }
}
