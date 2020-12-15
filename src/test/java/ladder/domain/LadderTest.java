package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderTest {

    @Test
    @DisplayName("Ladder - Users, Lines 객체 비교")
    void ladder_isEqualTo() {
        Users users = Users.of("pobi,honux,crong,jk");
        Lines lines = Lines.of(GameSetup.of(users.countOfPerson(),5), new NextDirectionRule());

        Ladder ladder = Ladder.of(users,lines);

        assertAll(
                () -> assertThat(ladder.getUsers()).isEqualTo(users),
                () -> assertThat(ladder.getLines()).isEqualTo(lines)
        );
    }
}
