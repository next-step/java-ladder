package ladder.game;

import ladder.model.ladder.Height;
import ladder.model.ladder.Ladder;
import ladder.model.result.Results;
import ladder.model.stringas.StringAsHeight;
import ladder.model.player.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameApp {

    public static void main(String[] args) {
        try {
            Players players = new Players(InputView.getStringValue("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"));
            Results results = new Results(InputView.getStringValue("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)"), players.count());
            Height height = new StringAsHeight(InputView.getStringValue("최대 사다리 높이는 몇 개인가요?")).get();
            Ladder ladder = Ladder.create(height.get(), players.count());
            ResultView.printLadderResult(players, ladder, results);
            LadderGame game = new LadderGame(ladder, players);
            ResultView.printResult(game.play(InputView.getStringValue("결과를 보고 싶은 사람은?")), results);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
