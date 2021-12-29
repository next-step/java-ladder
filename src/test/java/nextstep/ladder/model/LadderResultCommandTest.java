package nextstep.ladder.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"all", "crong", "pobi"})
    void fromTest(String value) {
        // when & then
        assertThat(LadderResultCommand.from(value)).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"all", "All", "ALL"})
    void isAllTrueTest(String allValue) {
        // given
        LadderResultCommand command = LadderResultCommand.from(allValue);
        // when & then
        assertThat(command.isAll()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"crong", "pobi", "javajigi"})
    void isAllFalseTest(String userName) {
        // given
        LadderResultCommand command = LadderResultCommand.from(userName);
        // when & then
        assertThat(command.isAll()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"crong", "pobi", "jake"})
    void userNameTest(String userName) {
        // given
        LadderResultCommand command = LadderResultCommand.from(userName);
        // when & then
        assertThat(command.userName()).isEqualTo(new UserName(userName));
    }
}
