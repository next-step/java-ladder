package ladder;

import ladder.domain.*;
import ladder.domain.ladder.LadderLine;
import ladder.domain.prize.Prizes;
import ladder.domain.prize.PrizesGenerator;
import ladder.domain.user.Users;
import ladder.domain.user.UsersGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.Map;

public class LadderMain {
    private static final String ALL = "all";

    public static void main(String[] args) {
        //1. 사다리 게임을 하기 위한 정보를 사용자 로부터 입력 받기
        final String usersExpression = InputView.plzEnterUserNames();
        final String prizesExpression = InputView.plzEnterPrizes();
        final int ladderHeight = InputView.plzEnterLadderHeight();

        //2. 유저와 상품을 만들기
        final Users users = UsersGenerator.generate(usersExpression);
        final Prizes prizes = PrizesGenerator.generate(prizesExpression);

        //3. 사다리 게임을 초기화 하기
        final LadderGame ladderGame = LadderGame.of(users.size(), ladderHeight);

        //4. 사다리 받기
        final List<LadderLine> ladderLines = ladderGame.getLadderLine();

        //5. 참여자와 사다리, 상품 그리기
        OutputView.printLadderViewResult(users.getNames(), ladderLines, prizes.getNames());

        //6. 사디리 게임 결과 받기
        final Map<String, String> ladderGameResult = ladderGame.play(users, prizes);

        //7. 사다리 게임 결과 확인
        checkResult(ladderGameResult);
    }

    private static void checkResult(final Map<String, String> ladderGameResult) {
        while (true) {
            final String userName = InputView.plzEnterUserName();
            if (ALL.equals(userName)) {
                OutputView.printAllUserResult(ladderGameResult);
                break;
            }
            OutputView.printUserResult(ladderGameResult, userName);
        }
    }
}
