package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.user.Users;
import ladder.domain.user.UsersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    @DisplayName("출력 테스트용")
    @Test
    void printUserNameTest() {
        // given
        final Users users = UsersGenerator.generate("pobi,honux,crong,jk,sung,min,hong");
        final LadderGame ladderGame = LadderGame.of(users.size(), 8);

        OutputView.printLadderViewResult(users.getNames(), ladderGame.getLadderLine());
    }

}