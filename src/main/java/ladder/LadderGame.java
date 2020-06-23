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
        Playing playing = Playing.of(players, results);
        int height = InputView.doInputLadderHeight();

        Game game = Game.play(playing, height);

        String targetPlayer = "";
        ResultView.printResult(game);
        while (!targetPlayer.equals("all")) {
            targetPlayer = InputView.doInputWantToSeeResult();
            ResultView.printResults(game.makeResult(playing.findPlayerIndexBy(targetPlayer)));
        }
    }
}