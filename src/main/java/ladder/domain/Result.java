package ladder.domain;

import ladder.strategy.LocationStrategy;
import ladder.view.OutputView;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Result {

    private Users users;
    private Ladder ladder;
    private WinningItems winningItems;
    private Map<String, String> result;

    public Result(Users users, Ladder ladder, WinningItems winningItems) {
        this.users = users;
        this.ladder = ladder;
        this.winningItems = winningItems;
        this.result = new HashMap<>();
    }

    public void calculateLadderResult() {
        for (int i = 0; i < users.getNames().size(); i++) {
            LocationStrategy locationStrategy = new LocationStrategy(i);
            ladder.getLines().forEach(locationStrategy::moveLocation);
            result.put(users.getNames().get(i).getName(), winningItems.getWinningItems().get(locationStrategy.getLocation()));
        }
    }

    public Map<String, String> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
