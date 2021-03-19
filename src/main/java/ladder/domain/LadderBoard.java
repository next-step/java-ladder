package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderBoard {

    private List<String> playerNameList;

    private List<Line> lineList;

    public LadderBoard(PlayerList participatingPlayerList, LineList lineList) {
        playerNameList = participatingPlayerList.playerList()
                .stream()
                .map(Player::name)
                .collect(Collectors.toList());
       this.lineList = lineList.lineList();
    }

    public List<String> playerNameList() {
        return playerNameList;
    }

    public List<Line> lineList() {
        return lineList;
    }


}
