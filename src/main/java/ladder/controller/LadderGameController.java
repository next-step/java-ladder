package ladder.controller;

import ladder.domain.model.*;
import ladder.domain.model.Param.LadderHeightParam;
import ladder.domain.model.Param.PlayerNameParam;
import ladder.domain.model.Param.PlayerNamesParam;
import ladder.domain.model.Param.WinResultsParam;
import ladder.domain.service.LadderGameService;
import ladder.domain.service.PlayerService;
import ladder.view.InPutView;
import ladder.view.OutPutView;

public class LadderGameController {
    public static void main(String[] args) {
        // 플레이어 네임들
        PlayerNamesParam playerNamesParam = InPutView.askPlayerNames();
        PlayerNames playerNames = playerNamesParam.convertParamToModel();

        PlayerService playerService = PlayerService.createPlayerService();
        Players players = playerService.createPlayers(playerNames);

        // 결과 상태 값
        WinResultsParam winResultsParam = InPutView.askWinResults();
        WinResults winResults = winResultsParam.convertParamToModel(players.getPlayerCount());
        winResults.createWinResultMap();

        // 사다리 높이
        LadderHeightParam ladderHeightParam = InPutView.askLadderHeight();
        LadderHeight ladderHeight = ladderHeightParam.convertParamToModel();

        // 사다리 타기 라인
        Lines lines = new Lines(playerNames.getCount(), ladderHeight.getHeight());
        Ladder ladder = new Ladder(players, lines);

        LadderGameService ladderGameService = LadderGameService.createLadderGameService();
        ladderGameService.startGame(ladder);

        OutPutView.outputGame(lines, playerNames, winResults);

        InPutView.newLineRemove();
        PlayerNameParam playerNameParam = InPutView.askPlayerWinResults();


        if (SearchType.ALL.equals(playerNameParam.getPlayerName())) {
            OutPutView.outPutWinResults(players, winResults);
        }

        if (SearchType.ALL.notEquals(playerNameParam.getPlayerName())) {
            Player player = playerService.searchPlayerResult(players, playerNameParam);
            OutPutView.outPutWinResult(player, winResults);
        }
    }
}
