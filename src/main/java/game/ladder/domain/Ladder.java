package game.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Created by yusik on 2019/11/11.
 */
public class Ladder {

    private static final LinkStrategy DEFAULT_STRATEGY = new RandomLinkStrategy();

    private final List<Line> lines;
    private final List<String> players;
    private final List<String> rewards;

    public Ladder(List<String> names, int height, List<String> rewards) {
        this(names, height, rewards, DEFAULT_STRATEGY);
    }

    public Ladder(List<String> names, int height, List<String> rewards, LinkStrategy linkStrategy) {
        this.players = names;
        this.rewards = rewards;
        int countOfPlayer = players.size();
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(countOfPlayer, linkStrategy))
                .collect(toList());
    }

    public List<String> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public List<String> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

    public String getResult(String player) {
        int startPosition = players.indexOf(player);
        if (startPosition < 0) {
            throw new IllegalArgumentException("찾을 수 없는 플레이어");
        }
        return rewards.get(getLastPosition(startPosition));
    }

    public int getLastPosition(int startPosition) {
        int position = startPosition;
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }
}
