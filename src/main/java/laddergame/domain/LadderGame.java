package laddergame.domain;

import laddergame.ui.InputView;
import laddergame.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private  static final String PLAYER_NAME_SEPERATOR = ",";

    private final InputView inputView;
    private final ResultView resultView;

    public LadderGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        Players players = getPlayers();
    }

    //region getPlayers
    private Players getPlayers() {
        String playerNames = inputView.getPlayerFromUser();
        String[] names = splitNames(playerNames);

        List<Player> players = new ArrayList<Player>();
        for (String name : names) {
            players.add(new Player(name));
        }
        return new Players(players);
    }

    private String[] splitNames(String playerNames){
        return playerNames.replace(" ", "").split(PLAYER_NAME_SEPERATOR);
    }
    //endregion
}
