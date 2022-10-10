package ladder.step2.domain;

import java.util.List;

public class Player {
    private final PlayerName playerName;
    private Position position;
    
    public Player(String input) {
        this(input, 0);
    }
    
    public Player(String playerName, int position) {
        this.playerName = new PlayerName(playerName);
        this.position = new Position(position);
    }
    
    public void move(final List<Line> line) {
        line.stream()
                .map(Line::getPartLines)
                .forEach(partLines -> this.position = position.move(partLines));
    }
    
    public PlayerName getPlayerName() {
        return playerName;
    }
    
    public Position getPosition() {
        return position;
    }
}
