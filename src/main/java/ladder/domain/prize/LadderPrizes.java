package ladder.domain.prize;

import java.nio.channels.NoConnectionPendingException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import ladder.exception.InvalidPrizeNamesException;

public class LadderPrizes {

    List<LadderPrize> prizes;

    private LadderPrizes(List<LadderPrize> prizes) {
        validate(prizes);
        this.prizes = prizes;
    }

    public static LadderPrizes of(List<String> prizes) {
        return Optional.ofNullable(prizes)
                .orElseThrow(InvalidPrizeNamesException::new)
                .stream()
                .map(LadderPrize::of)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LadderPrizes::new));
    }

    public LadderPrize getPrizeByIndex(int index) {
        return Optional.ofNullable(prizes.get(index))
                .orElseThrow(IndexOutOfBoundsException::new);
    }

    public int size() {
        return prizes.size();
    }

    public int maxLength() {
        return prizes.stream()
                .mapToInt(LadderPrize::length)
                .max()
                .orElseThrow(NoConnectionPendingException::new);
    }

    public List<LadderPrize> getPrizes() {
        return prizes;
    }

    private void validate(List<LadderPrize> prizes) {
        if (prizes == null || prizes.isEmpty()) {
            throw new InvalidPrizeNamesException();
        }
    }
}
