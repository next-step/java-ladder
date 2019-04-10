package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class LadderGame {
    private List<Position> users;
    private List<Position> results;
    private Ladder ladder;

    public LadderGame(List<String> userNames, List<String> resultNames, Integer height) {
        users = createPositions(userNames);
        results = createPositions(resultNames);

        ladder = new Ladder(users.size(), height);
    }

    public String search(String name) {
        Position user = users.stream()
            .filter(u -> u.getName().equals(name))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);

        Integer finalLocation = ladder.search(user.getLocation());

        return results.get(finalLocation - 1).getName();
    }

    public Map<String, String> search() {
        Map<String, String> result = new HashMap<>();

        for (Position user : users) {
            Integer finalLocation = ladder.search(user.getLocation());

            result.put(user.getName(), results.get(finalLocation - 1).getName());
        }

        return result;
    }

    public List<Position> getUsers() {
        return users;
    }

    public List<Position> getResults() {
        return results;
    }

    public Ladder getLadder() {
        return ladder;
    }

    private static List<Position> createPositions(List<String> names) {
        AtomicInteger integer = new AtomicInteger(1);
        return names.stream()
            .map(s -> new Position(s, integer.getAndIncrement()))
            .collect(Collectors.toList());
    }
}
