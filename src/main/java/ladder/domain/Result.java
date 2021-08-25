package ladder.domain;

import ladder.view.OutputView;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Result {

    private Users users;
    private Ladder ladder;
    private WinningItems winningItems;
    private Map<String, String> result = new HashMap<>();

    public Result(Users users, Ladder ladder, WinningItems winningItems) {
        this.users = users;
        this.ladder = ladder;
        this.winningItems = winningItems;
    }

    public void printLadderInfo() {
        OutputView.printNames(users);
        OutputView.printLadder(ladder);
        OutputView.printItems(winningItems);
    }

    public void calculateLadderResult() {
        for (int i = 0; i < users.getNames().size(); i++) {
            Location location = new Location(i);
            ladder.getLines().stream().forEach(location::moveLocation);
            result.put(users.getNames().get(i).getName(), winningItems.getWinningItems().get(location.getLocation()));
        }
    }

    public void printResult(String name) {
        OutputView.printResult(name, result);
    }

}
