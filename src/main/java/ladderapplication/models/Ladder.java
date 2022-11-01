package ladderapplication.models;

import ladderapplication.models.requests.GameSettingRequest;
import ladderapplication.models.requests.LadderRequest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private static final int NAME_SPACE = 6;
    private static final int STANDARD_SIZE = 4;
    private final List<Player> players;
    private final List<Line> lines;

    public Ladder(List<Player> players, List<Line> lines) {
        this.players = players;
        this.lines = lines;
    }

    public static Ladder of(GameSettingRequest gameSettingRequest) {
        List<Player> newPlayers = gameSettingRequest.getPlayerRequests()
                .stream()
                .map(Player::from)
                .collect(Collectors.toList());

        List<Line> newLines = Stream.generate(() -> Line.of(gameSettingRequest.getPlayerRequests().size()))
                .limit(gameSettingRequest.getLadderRequest().getHeight())
                .collect(Collectors.toList());
        return new Ladder(newPlayers, newLines);
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
        return sb.toString();
    }

    private String getSpace(int count) {
        String space = " ";
        return space.repeat(count);
    }
}
