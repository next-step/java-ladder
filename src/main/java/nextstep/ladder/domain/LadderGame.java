package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private Players players;
    private Ladder ladder;

    public LadderGame(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

   public LadderResult start(Result result) {
       Map<String, String> gameResult = new HashMap<>();
       for (int i = 0; i < players.size(); i++) {
           int index = ladder.move(i);
           String ladderResult = result.get(index);
           gameResult.put(players.name(i), ladderResult);
       }
       return new LadderResult(gameResult);
   }
}
