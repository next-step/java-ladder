package step3.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Result {

    private Map<String, Prize> result;

    public Result(Map<String, Prize> result) {
        this.result = result;
    }

    public Map<String, Prize> getResult() {
        return this.result;
    }


    public static Result of(List<Player> players, List<Prize> prizes, LadderGame ladderGame) {
        Map<String, Prize> result = new HashMap<>();
        int[] lineIndex = {0};
        IntStream.range(0, players.size() - 1)
                .forEach(index -> result.put(players.get(index).getName(), ladderResult(lineIndex[0], prizes, ladderGame)));

        return new Result(result);
    }

    public static Prize ladderResult(int nameIndex, List<Prize> prizes, LadderGame ladderGame) {
        int[] lineIndex = {nameIndex};
        ladderGame.getLines().forEach(line -> lineIndex[0] = line.move(lineIndex[0]));
        return prizes.get(lineIndex[0]);
    }
}
