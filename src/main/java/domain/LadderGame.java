package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private Positions users;
    private Positions results;
    private Ladder ladder;

    public LadderGame(List<String> userNames, List<String> resultNames, Integer height) {
        users = new Positions(userNames);
        results = new Positions(resultNames);

        ladder = new Ladder(userNames.size(), height);
    }

    public String search(String name) {
        Integer finalLocation = ladder.search(users.findByName(name));

        return results.findByLocation(finalLocation);
    }

    public List<String> search() {
        return users.getLocations().stream()
            .map(ladder::search)
            .map(results::findByLocation)
            .collect(Collectors.toList());
    }

    public Positions getUsers() {
        return users;
    }

    public Positions getResults() {
        return results;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
