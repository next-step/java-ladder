package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final List<Player> players;
    private final List<Line> lines = new ArrayList<>();
    private final List<String> results = new ArrayList<>();

    public Ladder(List<String> names, int height, List<String> result) {
        this.players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
        for (int i = 0; i < height; i++) {
            this.lines.add(new Line(players.size()));
        }
        this.results.addAll(result);
    }

    public Ladder(List<String> names, List<Line> lines, List<String> result) {
        this.players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
        this.lines.addAll(lines);
        this.results.addAll(result);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Line> getLines() {
        return lines;
    }

    private int matchedPoint(int index){
        int resultIndex = index;
        for (Line line : lines) {
            if (resultIndex < lines.size() && line.point(resultIndex)) {
                resultIndex += 1;
                continue;
            }
            if(resultIndex > 0 && line.point(resultIndex -1)){
                resultIndex -= 1;
            }
        }
        return resultIndex;
    }

    private int matchedIndex(Player player){
        for(int i=0; i <= players.size(); i++) {
            if(players.get(i).equals(player)){
                return i;
            }
        }
        throw new IllegalArgumentException("해당 player를 찾을 수 없습니다.");
    }

    private String matchedResult(Player player){
        int playerIndex = matchedIndex(player);
        int matchedIndex = matchedPoint(playerIndex);
        return results.get(matchedIndex);
    }

    public String matchedResult(String name) {
        return matchedResult(new Player(name));
    }

        @Override
    public String toString() {
        return "Ladder {" +
                "    players = " + players + ",\n" +
                "    lines = " + lines + ",\n" +
                "    results = " + results + "\n" +
                '}';
    }
}
