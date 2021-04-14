package nextstep.refactoring;

import nextstep.ladder.view.InputView;
import nextstep.refactoring.ladder.engine.Ladder;
import nextstep.refactoring.ladder.engine.LadderCreator;
import nextstep.refactoring.laddergame.engine.LadderGame;
import nextstep.refactoring.laddergame.engine.LadderGameResultDto;
import nextstep.refactoring.laddergame.engine.PlayerNameKeyword;
import nextstep.refactoring.laddergame.engine.player.Players;
import nextstep.refactoring.laddergame.engine.reward.Rewards;
import nextstep.refactoring.laddergame.factory.LadderGameFactory;
import nextstep.refactoring.view.interfaces.ResultView;
import nextstep.refactoring.view.interfaces.ViewObject;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

    private final LadderCreator ladderCreator;

    public LadderGameController(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
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

        LadderGame ladderGame = LadderGameFactory.ladderGame(ladder);

        PlayerNameKeyword playerNameKeyword = new PlayerNameKeyword(inputView.receiveNameForSeeingResult());
        List<LadderGameResultDto> results = ladderGame.getResult(players, rewards, playerNameKeyword)
                                                      .stream().map(ViewObject::export).collect(Collectors.toList());
        resultView.printLadderGameResults(results);
    }

}
