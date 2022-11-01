package ladderapplication.models;

import ladderapplication.models.requests.GameSettingRequest;
import ladderapplication.utils.DecoratingUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Player> players;
    private final List<Line> lines;
    private final String drawing;

    private Ladder(List<Player> players, List<Line> lines, String drawing) {
        this.players = players;
        this.lines = lines;
        this.drawing = drawing;
    }

    public static Ladder from(GameSettingRequest gameSettingRequest) {
        List<Player> newPlayers = gameSettingRequest.getPlayerRequests()
                .stream()
                .map(Player::from)
                .collect(Collectors.toList());

        int playerCount = gameSettingRequest.getPlayerRequests().size();
        int ladderHeight = gameSettingRequest.getLadderRequest().getHeight();
        List<Line> newLines = Stream.generate(() -> Line.of(playerCount))
                .limit(ladderHeight)
                .collect(Collectors.toList());

        String drawing = createDrawing(newPlayers, newLines);
        return new Ladder(newPlayers, newLines, drawing);
    }

    private static String createDrawing(List<Player> players, List<Line> lines) {
        StringBuilder sb = new StringBuilder();
        addPlayerNames(sb, players);
        addLines(sb, lines);
        return sb.toString();
    }

    private static void addPlayerNames(StringBuilder sb, List<Player> players) {
        players.forEach(player -> sb.append(DecoratingUtils.getDecoratedName(player.getName())));
        sb.append("\n");
    }

    private static void addLines(StringBuilder sb, List<Line> lines) {
        lines.forEach(line -> sb.append(line.print()).append("\n"));
    }

    public void print() {
        System.out.println(this.drawing);
    }
}
