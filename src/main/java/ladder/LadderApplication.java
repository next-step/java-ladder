package ladder;

import ladder.domain.Destinations;
import ladder.domain.Players;
import ladder.domain.factory.DestinationFactory;
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

        validateDestinations(players, destinations);

        int height = InputView.getLadderHeight();
        LadderGame ladderGame = new LadderGame(players, destinations, height);

        OutputView.printLadderGame(ladderGame);

        List<String> wantedPlayersNames = InputView.getWantedPlayersNames();
        Players wantedPlayers = players.of(wantedPlayersNames);

        OutputView.printResults(ladderGame.wantedResults(wantedPlayers));
    }

    private static void validateDestinations(Players players, Destinations destinations){
        if (players.count() != destinations.count()){
            throw new IllegalArgumentException("참가자 수와 실행 결과 수는 같아야 합니다");
        }
    }
}
