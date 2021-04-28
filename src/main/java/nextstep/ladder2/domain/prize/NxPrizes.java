package nextstep.ladder2.domain.prize;

import java.util.List;
import java.util.stream.Collectors;

public class NxPrizes {
    private final List<NxPrize> prizes;

    public NxPrizes(List<String> prizeNames) {
        prizes = prizeNames.stream()
                .map(NxPrize::new)
                .collect(Collectors.toList());
    }

    public NxPrize getPrizeByIndex(int index) {
        return prizes.get(index);
    }

    public List<String> getAllPrizesName() {
        return prizes.stream()
                .map(NxPrize::getPrizeName)
                .collect(Collectors.toList());
    }
}
