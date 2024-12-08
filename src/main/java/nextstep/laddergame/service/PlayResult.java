package nextstep.laddergame.service;

import nextstep.laddergame.domain.LadderResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class PlayResult {
    private final Map<Integer, Integer> playResult;

    public PlayResult() {
        this.playResult = new HashMap<>();
    }

    public void add(int initPosition, int resultPosition) {
        this.playResult.put(initPosition, resultPosition);
    }

    public LadderResult map(List<String> participantsName, List<String> ladderOutputs) {
        return new LadderResult(
                IntStream.range(0, participantsName.size())
                        .boxed()
                        .collect(HashMap::new,
                                (map, position) -> {
                                    Integer finalPosition = playResult.get(position);
                                    map.put(participantsName.get(position), ladderOutputs.get(finalPosition));
                                }, HashMap::putAll)
        );
    }
}
