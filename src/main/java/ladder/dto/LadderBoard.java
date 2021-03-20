package ladder.dto;

import ladder.domain.LineList;
import ladder.domain.Player;
import ladder.domain.PlayerList;

import java.util.List;
import java.util.stream.Collectors;

public class LadderBoard {

    private List<String> playerNameList;

    private List<LineDto> lineList;

    private static final String LINE_BREAK = "\n";

    public LadderBoard(PlayerList participatingPlayerList, LineList lineList) {
        playerNameList = participatingPlayerList.playerList()
                .stream()
                .map(Player::name)
                .collect(Collectors.toList());
        this.lineList = lineList.lineList()
                .stream().map(LineDto::new)
                .collect(Collectors.toList());
    }

    public List<String> playerNameList() {
        return playerNameList;
    }

    public String lineListToString() {
        StringBuilder builder = new StringBuilder();
        for (LineDto line : lineList) {
            builder.append(line.toString());
            builder.append(LINE_BREAK);
        }
        return builder.toString();
    }

}
