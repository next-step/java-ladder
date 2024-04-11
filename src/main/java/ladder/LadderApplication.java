package ladder;

import ladder.domain.Destinations;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.factory.DestinationFactory;
import ladder.domain.factory.LadderFactory;
import ladder.domain.factory.PlayerFactory;
import ladder.service.LadderGame;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args){

        List<String> playersNames = InputView.getPlayersNames();
        Players players = PlayerFactory.create(playersNames);

        List<String> destinationsString = InputView.getDestinationsResults();
        Destinations destinations = DestinationFactory.create(destinationsString);

        int height = InputView.getLadderHeight();
        Ladder ladder = LadderFactory.create(players, destinations, height);
        OutputView.printLadder(ladder);

        List<String> wantedPlayersNames = InputView.getWantedPlayersNames();
        Players wantedPlayers = players.of(wantedPlayersNames);

        LadderGame ladderGame = new LadderGame();
        OutputView.printResults(ladderGame.wantedResults(ladder, wantedPlayers));
    }

}
