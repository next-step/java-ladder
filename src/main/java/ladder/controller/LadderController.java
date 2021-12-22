package ladder.controller;

import ladder.domain.dto.LadderInfoDto;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.result.ExecutionResults;
import ladder.domain.user.LadderPlayers;
import ladder.domain.user.PlayerName;
import ladder.generator.LadderGenerator;
import ladder.strategy.PlayResult;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Map;

public class LadderController {

    public static final String ALL_RESULTS = "all";

    private final LadderGenerator ladderGenerator;
    private final PlayResult playResult;

    public LadderController(LadderGenerator ladderGenerator, PlayResult playResult) {
        this.ladderGenerator = ladderGenerator;
        this.playResult = playResult;
    }

    public void start() {
        LadderInfoDto infoDto = new LadderInfoDto(InputView.printInputNames(), InputView.printInputItems(), InputView.printInputLadderHeight());
        LadderPlayers players = infoDto.getLadderPlayers();
        ExecutionResults items = infoDto.getExecutionResults();
        LadderHeight height = infoDto.getHeight();

        Ladder ladder = ladderGenerator.generate(players.size(), height);

        printLadderTotalView(players, items, ladder);

        Map<PlayerName, String> result = playResult.play(ladder, infoDto);

        printGameResults(players, result);
    }

    private void printLadderTotalView(LadderPlayers players, ExecutionResults items, Ladder ladder) {
        ResultView.printLadderResult(players.getPlayers(), ladder.getLines());
        ResultView.printItems(items);
    }

    private void printGameResults(LadderPlayers players, Map<PlayerName, String> result) {
        String targetName = InputView.printInputFindPlayer();

        if (isAll(targetName)) {
            ResultView.printResults(players.getPlayerNames(), result);
            return;
        }

        PlayerName findName = players.findByName(targetName);
        ResultView.printSingleResult(result.get(findName));

        printGameResults(players, result);
    }

    private boolean isAll(String wantedName) {
        return wantedName.equalsIgnoreCase(ALL_RESULTS);
    }

}
