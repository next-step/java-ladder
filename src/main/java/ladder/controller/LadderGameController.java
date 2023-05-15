package ladder.controller;

import ladder.domain.model.LadderHeight;
import ladder.domain.model.Lines;
import ladder.domain.model.Param.LadderHeightParam;
import ladder.domain.model.Param.PlayerNamesParam;
import ladder.domain.model.PlayerNames;
import ladder.domain.service.LadderGameService;
import ladder.view.InPutView;
import ladder.view.OutPutView;

public class LadderGameController {
    public static void main(String[] args) {
        PlayerNamesParam playerNamesParam = InPutView.askPlayerNames();
        PlayerNames playerNames = playerNamesParam.convertParamToModel();

        LadderHeightParam ladderHeightParam = InPutView.askLadderHeight();
        LadderHeight ladderHeight = ladderHeightParam.convertParamToModel();

        LadderGameService ladderGameService = LadderGameService.createLadderGameService();
        Lines lines = ladderGameService.startGame(playerNames, ladderHeight);

        OutPutView.outputGame(lines, playerNames);
    }
}
