package ladder.dto;

import ladder.domain.Prize;
import ladder.domain.LadderBoard;
import ladder.domain.Player;
import ladder.domain.PlayerList;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResultDto {

    private List<String> playerNameList;

    private List<String> prizeNameList;

    private List<LineDto> lineList;

    public LadderResultDto(PlayerList participatingPlayerList, LadderBoard ladderBoard) {
        playerNameList = participatingPlayerList.playerList()
                .stream()
                .map(Player::name)
                .collect(Collectors.toList());
        prizeNameList = ladderBoard.prizeList()
                .stream().map(Prize::prizeName)
                .collect(Collectors.toList());
        lineList = ladderBoard.lineList()
                .stream().map(LineDto::new)
                .collect(Collectors.toList());
    }

    public List<String> playerNameList() {
        return playerNameList;
    }

    public List<String> prizeNameList() {
        return prizeNameList;
    }

    public List<LineDto> lineList() {
        return lineList;
    }

}
