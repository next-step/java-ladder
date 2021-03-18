package ladder.domain;

import ladder.LineList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderBoard {

    private List<String> playerNameList = new ArrayList<>();

    private List<Line> lineList = new ArrayList<>();

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
