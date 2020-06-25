package nextstep.step4.domain;

import nextstep.step4.domain.strategy.DrawLineStrategy;
import nextstep.step4.resource.LadderStringResource;

import java.util.*;

public class Ladder {
    private List<LadderLine> lines = new ArrayList<>();

    public Ladder(int userCount, int ladderHeight, DrawLineStrategy drawLineStrategy) {
        for(int i=0; i<ladderHeight; i++){
            lines.add(new LadderLine(userCount, drawLineStrategy));
        }
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

    private int play(int idx) {
        for(LadderLine line : lines) {
            idx = line.move(idx);
        }
        return idx;
    }

    public List<LadderLine> getLines() {
        return lines;
    }
}
