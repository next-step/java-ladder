package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;

public class PrizeTable {
    private final Map<String, String> prizeMap;

    private PrizeTable(Map<String, String> prizeMap) {
        this.prizeMap = prizeMap;
    }

    public static PrizeTable of(List<String> attendees, List<String> prizes, List<Integer> result) {
        if(attendees.size() != prizes.size()) {
            throw new IllegalArgumentException("count of attendees and prize not equals");
        }
        return new PrizeTable(
            IntStream.range(0, attendees.size())
                .collect(HashMap::new, (m, i) -> m.put(attendees.get(result.get(i)), prizes.get(i)), HashMap::putAll)
        );
    }

    public boolean contains(String whosePrize) {
        return prizeMap.containsKey(whosePrize);
    }

    public String getPrize(String whosePrize) {
        return prizeMap.get(whosePrize);
    }

    public void forEach(BiConsumer<? super String, ? super String> action) {
        prizeMap.forEach(action);
    }
}
