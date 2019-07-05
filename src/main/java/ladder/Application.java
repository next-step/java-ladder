package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        Players players = Players.of(InputView.askPlayers());
        Height height = Height.from(InputView.askHeight());

        Ladder ladder = Ladder.from(players, height);

        Map<Player, Prize> resultMap = new HashMap<>();
        for (int i = 0; i < players.numberOfPlayers(); i++) {
            Player player = players.getPlayers().get(i);
            Position finalPosition = ladder.goThroughLines(Position.from(i));// i(position)에서 시작해서 사다리 타고 나서의 position
//            prize = prizes.get(finalPosition); // Prizes의 position위치의 Prize
//            resultMap.put(player, prize);
        }

        OutputView.printResult(players, ladder);
    }
}
