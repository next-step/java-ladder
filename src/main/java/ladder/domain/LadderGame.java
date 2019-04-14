package ladder.domain;


import ladder.domain.generator.LadderGenerator;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private final LadderGenerator ladderGenerator;
    private Ladder ladder;

    public LadderGame(LadderGenerator ladderGenerator) {
        this.ladderGenerator = ladderGenerator;
    }

    public void init(int countOfPerson, int height) {
        this.ladder = ladderGenerator.generate(countOfPerson, height);
    }

    public GameResults play(Players players, BetItems betItems) {
        verifyGamePlay(players, betItems);

        Map<Player, BetItem> result = new HashMap<>();
        for (int i = 0; i < players.getCount(); i++) {
            int endIndex = ladder.descend(i);
            result.put(players.get(i), betItems.get(endIndex));
        }
        return new GameResults(result);
    }

    private void verifyGamePlay(Players players, BetItems betItems) {
        if (!players.isEqualCount(betItems)) {
            throw new RuntimeException("사다리게임의 참여인원과 내기의 개수가 달라 게임을 진행할 수 없습니다.");
        }
    }

    public Ladder getLadder() {
        return ladder;
    }
}
