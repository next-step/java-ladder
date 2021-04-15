package nextstep.refactoring;

import nextstep.ladder.view.InputView;
import nextstep.refactoring.ladder.engine.Ladder;
import nextstep.refactoring.ladder.engine.LadderCreator;
import nextstep.refactoring.laddergame.engine.LadderGame;
import nextstep.refactoring.laddergame.engine.LadderGameCreator;
import nextstep.refactoring.laddergame.engine.LadderGameResultDto;
import nextstep.refactoring.laddergame.engine.PlayerNameKeyword;
import nextstep.refactoring.laddergame.engine.player.Players;
import nextstep.refactoring.laddergame.engine.reward.Rewards;
import nextstep.refactoring.view.interfaces.ResultView;
import nextstep.refactoring.view.interfaces.ViewObject;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

    private final LadderCreator ladderCreator;
    private final LadderGameCreator ladderGameCreator;

    public LadderGameController(LadderCreator ladderCreator, LadderGameCreator ladderGameCreator) {
        this.ladderCreator = ladderCreator;
        this.ladderGameCreator = ladderGameCreator;
    }

    public void startGame(InputView inputView, ResultView resultView) {
        List<String> names = inputView.receivePlayerNames();
        Players players = Players.of(names);
        Rewards rewards = Rewards.of(inputView.receiveRewards());

        int height = inputView.receiveLadderHeight();
        Ladder ladder = ladderCreator.create(height, names.size());

        resultView.printPlayers(players.export());
        resultView.printLadder(ladder.export());
        resultView.printRewards(rewards.export());

        LadderGame ladderGame = ladderGameCreator.create(ladder);

        PlayerNameKeyword playerNameKeyword = new PlayerNameKeyword(inputView.receiveNameForSeeingResult());
        List<LadderGameResultDto> results = ladderGame.getResult(players, rewards, playerNameKeyword)
                                                      .stream().map(ViewObject::export).collect(Collectors.toList());
        resultView.printLadderGameResults(results);
    }

}
