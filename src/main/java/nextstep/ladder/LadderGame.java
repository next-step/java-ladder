package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;
import nextstep.ladder.exception.LadderException;
import nextstep.ladder.view.Input;
import nextstep.ladder.view.Output;

import java.util.List;

public class LadderGame {
    public static void main(String[] args) {
        try {
            List<String> playersAsString = Input.askPlayers();
            Players players = Players.of(playersAsString);
            List<String> results = Input.askResults(players);

            Height height = Input.askLadderHeight();
            Ladder ladder = Ladder.init(players.countOfLines(), height);
            ladder.create(height);
            ladder.validateLadder();
            ladder.execute(players, height, results);

            Output.printPlayers(players);
            Output.printLadder(ladder, height);
            Output.printResults(results);

            String name = Input.askWhichPlayerToKnow();
            List<Player> selectedPlayers = players.player(name);

            Output.printResultsOfPlayers(selectedPlayers);
        } catch (LadderException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.printf("알 수 없는 서버에러 발생 : %s", e.getMessage());
        }
    }
}
