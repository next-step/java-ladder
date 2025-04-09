package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.Players;
import ladder.domain.ladderlinegenerator.RandomLadderLineGenerator;
import ladder.views.InputView;
import ladder.views.ResultView;

public class LadderGameApplication {
    public static void main(String[] args) {
        Players players = InputView.createPlayersWithQuery("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Height height = InputView.createIntegerWithQuery("최대 사다리 높이는 몇 개인가요?");
        Ladder ladder = new Ladder(height.value(), players.count(), new RandomLadderLineGenerator());
        LadderGame ladderGame = new LadderGame(players, null, height);

        ResultView.printResult(ladder, ladderGame);
    }
}
