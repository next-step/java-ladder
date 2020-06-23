package nextstep.step3.domain;

import nextstep.step3.domain.strategy.Position;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<User> getLadderGameResult(List<String> userNames) {
        List<User> users = new ArrayList<>();
        for(int i=0; i<userNames.size(); i++){
            users.add(new User(userNames.get(i), play(i)));
        }
        return users;
    }

    private int play(int startBreathPosition) {
        Position position = new Position(startBreathPosition);
        for(Line line : lines) {
            position.movePosition(line);
        }
        return position.getBreath();
    }

}
