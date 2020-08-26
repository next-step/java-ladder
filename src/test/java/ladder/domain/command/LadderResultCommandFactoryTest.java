package ladder.domain.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultCommandFactoryTest {

    @Test
    @DisplayName("command 수행 순서 확인")
    void testCommandOrder() {
        LadderResultCommand command = LadderResultCommandFactory.ladderResultCommand("all");
        assertThat(command).isInstanceOf(AllResultCommand.class);
    }

    @Test
    @DisplayName("사람 명 전달 시 명령어 확인")
    void testPersonResultCommandReturn() {
        LadderResultCommand command = LadderResultCommandFactory.ladderResultCommand("dddd");
        assertThat(command).isInstanceOf(PersonResultCommand.class);
    }
}
