package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private List<LadderLine> ladderLine;
    private int width;

    public Ladder(int playerCount, int height) {
        this.ladderLine = IntStream.range(0, height)
                .mapToObj(i -> LadderLine.create(playerCount))
                .collect(Collectors.toList());

        this.width = playerCount;
    }

    public List<LadderLine> getLadderLine() {
        return ladderLine;
    }

    public List<Integer> getResult() {
        List<Integer> rankResult = new ArrayList<>();

        for (int position = 0; position < width; position++) {
            int nowPosition = position;

            for (int height = 0; height < ladderLine.size(); height++) {
                nowPosition = ladderLine.get(height).move(nowPosition);
            }

            rankResult.add(nowPosition);
        }

        return rankResult;
    }

}

