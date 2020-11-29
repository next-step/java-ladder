package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.prize.Prizes;
import ladder.domain.prize.PrizesGenerator;
import ladder.domain.user.Users;
import ladder.domain.user.UsersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private final Users users = UsersGenerator.generate("pobi,honux,crong,jk,sung,min,hong");
    private final Prizes prizes = PrizesGenerator.generate("꽝,꽝,꽝,1000,100,10000,꽝");
    private final LadderGame ladderGame = LadderGame.of(users.size(), 8);

    @DisplayName("사다리 출력 테스트용")
    @Test
    void print_ladder_test() {
        OutputView.printLadderViewResult(users.getNames(), ladderGame.getLadderLine(), prizes.getNames());
    }

    @DisplayName("특정 유저의 사다리 게임 결과 출력 테스트용")
    @Test
    void print_ladderGameResult_test() {
        final String userName = "pobi";
        OutputView.printUserResult(ladderGame.play(users, prizes), userName);
    }

    @DisplayName("사다리 게임 전체 결과 출력 테스트용")
    @Test
    void print_all_LadderGameResult_test() {
        OutputView.printAllUserResult(ladderGame.play(users, prizes));
    }
    
    @Test
    void print_all() {
        print_ladder_test();
        print_ladderGameResult_test();
        print_all_LadderGameResult_test();
    }
}