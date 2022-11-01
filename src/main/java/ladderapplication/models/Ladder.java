package ladderapplication.models;

import ladderapplication.models.requests.LadderRequest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private static final int NAME_SPACE = 6;
    private static final int STANDARD_SIZE = 4;
    private final List<Player> players;
    private final List<Line> lines;
    private final int height;

    public Ladder(List<Player> players, List<Line> lines, int height) {
        this.players = players;
        this.lines = lines;
        this.height = height;
    }

    public static Ladder of(LadderRequest ladderRequest, List<Player> players) {
        List<Line> newLines = Stream.generate(() -> Line.of(players.size()))
                .limit(ladderRequest.getHeight())
                .collect(Collectors.toList());
        return new Ladder(players, newLines, ladderRequest.getHeight());
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        players.forEach(player -> sb.append(DecoratingName(player.getName())));
        sb.append("\n");

        lines.forEach(line -> sb.append(line.getLine()).append("\n"));
        System.out.print(sb);
    }

    private String DecoratingName(String name) {
        StringBuilder sb = new StringBuilder();
        if (name.length() < STANDARD_SIZE) {
            sb.append(getSpace(STANDARD_SIZE - name.length()));
        }
        sb.append(name);
        sb.append(getSpace(NAME_SPACE - sb.length()));
        System.out.println(sb);
        return sb.toString();
    }

    private String getSpace(int count) {
        String space = " ";
        return space.repeat(count);
    }
}
