package ladder;

import ladder.domain.ladder.Game;
import ladder.domain.play.Items;
import ladder.domain.play.Playing;
import ladder.util.ConvertUtils;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    public static void main(String[] args) {
        Items players = Items.of(ConvertUtils.split(InputView.doInputParticipants()));
        Items results = Items.of(ConvertUtils.split(InputView.doInputResults()));
        int height = InputView.doInputLadderHeight();

        Game game = Game.play(Playing.of(players, results), height);
        ResultView.printResult(game);
    }
}