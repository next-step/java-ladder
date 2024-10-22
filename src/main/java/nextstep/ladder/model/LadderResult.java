package nextstep.ladder.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderResult {
    private LinkedHashMap<Player, Prize> result;

    public static LadderResult of(List<Player> players, List<Prize> prizes) {
        LinkedHashMap<Player, Prize> result = IntStream.range(0, players.size())
                .boxed()
                .collect(Collectors.toMap(
                        players::get,
                        prizes::get,
                        (existing, replacement) -> existing,
                        LinkedHashMap::new
                ));
        return new LadderResult(result);
    }

    public LadderResult(LinkedHashMap<Player, Prize> result) {
        this.result = result;
    }

    public LinkedHashMap<Player, Prize> getResult() {
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.result.forEach((key, value) -> sb.append(key.getName())
                .append(" : ")
                .append(value.getWorth())
                .append(", ")
        );
        return sb.toString();
    }
}
