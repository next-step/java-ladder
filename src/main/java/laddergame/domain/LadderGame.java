package laddergame.domain;

import laddergame.ui.InputView;
import laddergame.ui.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LadderGame {
    private  static final String PLAYER_NAME_SEPERATOR = ",";

    private final InputView inputView;
    private final ResultView resultView;
    private final LadderLineStatusGenerator generator;

    public LadderGame(InputView inputView, ResultView resultView, LadderLineStatusGenerator generator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.generator = generator;
    }

    public void run() {
        Players players = getPlayers();
        int ladderHeight = getLadderHeight();
        List<Line> ladder = createLadder(ladderHeight, players.size());
        resultView.showLadderGameResult(players, ladder);
    }

    //region getPlayers
    private Players getPlayers() {
        String playerNames = inputView.getPlayerFromUser();
        String[] names = splitNames(playerNames);

        List<Player> players = Arrays.stream(names)
                .map(Player::new)
                .collect(toList());

        return new Players(players);
    }

    private String[] splitNames(String playerNames){
        return playerNames.replace(" ", "").split(PLAYER_NAME_SEPERATOR);
    }
    //endregion

    private int getLadderHeight() {
        return inputView.getMaxLadderHeightFromUser();
    }

    private List<Line> createLadder(int ladderHeight, int playerCount) {
        List<Line> ladders = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            ladders.add(new Line(playerCount, generator));
        }
        return ladders;
    }
}
