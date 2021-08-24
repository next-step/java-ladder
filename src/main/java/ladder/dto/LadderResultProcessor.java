package ladder.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ladder.domain.player.PlayerName;
import ladder.domain.player.PlayerNames;
import ladder.domain.prize.LadderPrize;
import ladder.domain.prize.LadderPrizes;


public class LadderResultProcessor {

    private final List<PlayerName> names;
    private final List<LadderPrize> prizes;

    private LadderResultProcessor(List<PlayerName> names, List<LadderPrize> prizes) {
        this.names = names;
        this.prizes = prizes;
    }

    public static LadderResultProcessor of(PlayerNames playerNames, LadderPrizes ladderPrizes) {
        return new LadderResultProcessor(playerNames.getNames(), ladderPrizes.getPrizes());
    }

    public Map<String, String> process(LadderResult ladderResult) {
        Map<String, String> nameToPrize = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i).getName();
            int resultIndex = ladderResult.resultByIndex(i);
            String prize = prizes.get(resultIndex).getPrize();
            nameToPrize.put(name, prize);
        }
        return nameToPrize;
    }

    public PlayerName playerNameByIndex(int index) {
        return names.get(index);
    }

    public LadderPrize ladderPrizeByIndex(int index) {
        return prizes.get(index);
    }
}
