package ladder.domain.result;

import ladder.domain.ladder.Ladder;
import ladder.domain.players.Person;
import ladder.domain.players.Players;
import ladder.domain.rewards.Item;
import ladder.domain.rewards.Rewards;

public class LadderGame {
    private Players players;
    private Ladder ladder;
    private Rewards rewards;

    private LadderGame(Players players, Ladder ladder, Rewards rewards) {
        if (players.size() != rewards.size())
            throw new IllegalArgumentException();
        this.players = players;
        this.ladder = ladder;
        this.rewards = rewards;
    }

    public static LadderGame generate(Players players, Ladder ladder, Rewards rewards) {
        return new LadderGame(players, ladder, rewards);
    }

    public LadderResult result() {
        LadderResult ladderResult = new LadderResult();

        for (int i = 0; i < players.size(); i++) {
            Position position = Position.of(i);
            Person person = players.getPersonByIndex(i);

            this.ladder.move(position);

            Item item = rewards.getItemByIndex(position);
            ladderResult.addResult(person, item);
        }

        return ladderResult;
    }
}
