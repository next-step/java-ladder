package ladder.domain.data;

import ladder.domain.player.Name;
import ladder.domain.result.Reward;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RewardData {

    public static List<Reward> make(int count) {
        return IntStream.range(0, count)
                .mapToObj(Integer::toString)
                .map(Name::valueOf)
                .map(Reward::create)
                .collect(Collectors.toList());
    }
}
