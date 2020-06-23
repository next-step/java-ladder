package nextstep.step3.domain;

import nextstep.step3.domain.strategy.DrawLineStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private List<Line> lines;

    public Ladder(int userCount, int ladderHeight, DrawLineStrategy drawLineStrategy) {
        this.lines = Stream.generate(() -> new Line(userCount, drawLineStrategy))
                .limit(ladderHeight)
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }

    public Map<String, User> getLadderGameResult(List<String> userNames, List<String> playResult) {
        Map<String, User> resultMap = new HashMap<>();
        for(int i=0; i<userNames.size(); i++){
            String userName = userNames.get(i);
            String result = playResult.get(play(i));
            resultMap.put(userName, new User(userName, result));
        }
        return resultMap;
    }

    private int play(int startBreathPosition) {
        Position position = new Position(startBreathPosition);
        for(Line line : lines) {
            position.movePosition(line);
        }
        return position.getBreath();
    }

}
