package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;
import nextstep.ladder.exception.LadderException;
import nextstep.ladder.view.Input;
import nextstep.ladder.view.Output;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    public static void main(String[] args) {
        try {
            List<String> playersAsString = Input.askPlayers();
            Players players = Players.of(playersAsString);

            Height height = Input.askLadderHeight();
            Ladder ladder = Ladder.init(players.countOfLines(), height);
            ladder.create(height);

            Output.printPlayers(players);
            Output.printLadder(ladder, height);
        } catch (LadderException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.printf("알 수 없는 서버에러 발생 : %s", e.getMessage());
        }
    }
}
