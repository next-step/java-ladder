package ladder.domain.command;

import ladder.domain.element.Persons;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultCommandFactoryTest {

    @Test
    @DisplayName("command 수행 순서 확인")
    void testCommandOrder() {
        Persons persons = Persons.fromText("pobi,honux,crong,jk");
        LadderResultCommand command = LadderResultCommandFactory.ladderResultCommand(persons, "all");
        assertThat(command).isInstanceOf(AllResultCommand.class);
    }

    @Test
    @DisplayName("사람 명 전달 시 명령어 확인")
    void testPersonResultCommandReturn() {
        Persons persons = Persons.fromText("pobi,honux,crong,jk");
        LadderResultCommand command = LadderResultCommandFactory.ladderResultCommand(persons, "honux");
        assertThat(command).isInstanceOf(PersonResultCommand.class);
    }
}
