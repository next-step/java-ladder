package ladder.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import ladder.domain.player.PlayerName;
import ladder.domain.player.PlayerNames;
import ladder.domain.prize.LadderPrize;
import ladder.domain.prize.LadderPrizes;
import ladder.exception.InvalidNamesPrizesException;


public class LadderResultProcessor {

    private final List<String> names;
    private final List<String> prizes;

    private LadderResultProcessor(List<String> names, List<String> prizes) {
        validate(names, prizes);
        this.names = names;
        this.prizes = prizes;
    }

    public static LadderResultProcessor of(PlayerNames playerNames, LadderPrizes ladderPrizes) {
        List<String> names = playerNames.getNames()
                .stream()
                .map(PlayerName::getName)
                .collect(Collectors.toList());
        List<String> prizes = ladderPrizes.getPrizes()
                .stream()
                .map(LadderPrize::getPrize)
                .collect(Collectors.toList());
        return new LadderResultProcessor(names, prizes);
    }

    public Map<String, String> process(LadderResult ladderResult) {
        Map<String, String> nameToPrize = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            int target = ladderResult.findTarget(i);
            String prize = prizes.get(target);
            nameToPrize.put(name, prize);
        }
        return nameToPrize;
    }

    public String findName(int index) {
        return names.get(index);
    }

    public String findPrize(int index) {
        return prizes.get(index);
    }

    private void validate(List<String> names, List<String> prizes) {
        if (names == null || prizes == null || names.size() != prizes.size()) {
            throw new InvalidNamesPrizesException();
        }
    }
}
