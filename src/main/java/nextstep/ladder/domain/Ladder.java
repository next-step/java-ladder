package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> ladder;
    private final Players players;
    private final PointFactory pointFactory = new DefaultPointFactory();

    public Ladder(int ladderHeight, Players players) {
        checkLadderHeight(ladderHeight);

        this.players = players;
        this.ladder = createLine(ladderHeight);
    }

    public Ladder(List<Line> ladder, Players players) {
        this.players = players;
        this.ladder = ladder;
    }

    public PlayerWinnings movePlayer(String name, WinningItems winningItems) {
        return createPlayerWinnings(players.indexOf(name), winningItems);
    }

    public List<PlayerWinnings> movePlayerAll(WinningItems winningItems) {
        List<PlayerWinnings> playerWinnings = new ArrayList<>();
        IntStream.range(0, players.numberOfPlayers())
                .forEach(i -> playerWinnings.add(createPlayerWinnings(i, winningItems)));

        return playerWinnings;
    }

    private PlayerWinnings createPlayerWinnings(int playerIndex, WinningItems winningItems) {
        return new PlayerWinnings(Player.of(players.getPlayerNameByIndex(playerIndex)), winningItems.getWinningItem(move(playerIndex)));
    }

    private int move(int index) {
        for (Line line : ladder) {
            index = line.move(index);
        }

        return index;
    }

    private List<Line> createLine(int ladderHeight) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(players.numberOfPlayers(), pointFactory));
        }

        return lines;
    }

    private void checkLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException("높이는 1 이상으로 설정 하세요");
        }
    }

    @Override
    public String toString() {
        return players.toString() + "\n" + linesToString();
    }

    private String linesToString() {
        return ladder.stream()
                .map(Line::toString)
                .collect(Collectors.joining("\n"));
    }


}
