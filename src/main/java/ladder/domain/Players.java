package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    public final static String PLAYER_DELIMITER = ",";

    List<Player> players = new ArrayList<>();

    public Players(String players) {
        this.players = Arrays.stream(players.split(PLAYER_DELIMITER))
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public int getPlayerCount() {
        return players.size();
    }

    public String getPlayerName(int index) {
        return players.get(index).getName();
    }

    public void move(Line line) {
        for (int i = 0; i < line.getDrawLineCount(); i++) {
            swapPlayerPosition(line.getDrawByPosition(i), i);
        }
    }

    private void swapPlayerPosition(Draw draw, int position) {
        if (draw.getDrawableStatus()) {
            Collections.swap(players, position, position + 1);
        }
    }

}
