package ladder.controller;

import ladder.domain.*;
import ladder.dto.PlayerResultDto;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class LadderController {

    public static void main(String[] args) {
        Players players = InputView.inputPlayers();
        Results results = InputView.inputResults();
        int height = InputView.inputHeight();

        LadderGame ladderGame = new LadderGame(players.countOfPlayers(), height);

        ResultView.print(players);
        ResultView.print(ladderGame.getLadder());
        ResultView.print(results);

        Player inputPlayer = InputView.inputPlayer();

        while (!Player.isAllPlayer(inputPlayer)) {
            int playIdx = players.indexOf(inputPlayer);
            int resultIdx = ladderGame.result(playIdx);
            ResultView.print(results.get(resultIdx));
            inputPlayer = InputView.inputPlayer();
        }

        List<PlayerResultDto> playerResultDtoList = new ArrayList<>();

        IntStream.range(0, players.countOfPlayers()).forEach(playerIdx -> {
            int resultIdx = ladderGame.result(playerIdx);
            Player player = players.get(playerIdx);
            Result result = results.get(resultIdx);
            playerResultDtoList.add(new PlayerResultDto(player.getName(), result.getName()));
        });

        ResultView.print(playerResultDtoList);
    }
}
