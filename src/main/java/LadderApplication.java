import domain.Ladder;
import domain.Match;
import domain.Players;
import domain.Result;
import util.Console;
import view.InputView;
import view.ResultView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderApplication {
    public static void main(String[] args) {
        try {
            List<String> inputPlayer = Arrays.asList(InputView.inputPalyer().split(","));
            Players players = new Players(inputPlayer);
            int countOfPerson = players.countOfPerson();
            Result result = new Result(InputView.inputResult(), countOfPerson);
            int ladderHeight = InputView.inputLadderHeight();
            Ladder ladder = new Ladder(countOfPerson, ladderHeight);

            Console.print(players.toString());
            ResultView.printLine(ladder);
            Console.print(result.toString());
            String player = InputView.inputWho();

            Map<String, String> map = new HashMap<>();
            inputPlayer.forEach(playerName -> {
                Match match = new Match(players, playerName);
                int playerIndex = match.getPlayerIndex();
                int resultIndex = ladder.calcStartIndex(playerIndex);
                map.put(playerName, result.getResult(resultIndex));
            });

            if (player.equals("all")) {
                ResultView.allResult(map);
            } else {
                ResultView.result(player, map.get(player));
            }

        } catch (Exception e) {
            Console.print(e.getMessage());
        }
    }
}
