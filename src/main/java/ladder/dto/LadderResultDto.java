package ladder.dto;

import ladder.domain.LadderBoard;
import ladder.domain.Player;
import ladder.domain.PlayerList;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResultDto {

    private List<String> playerNameList;

    private LadderBoardDto ladderBoardDto;

    public LadderResultDto(PlayerList participatingPlayerList, LadderBoard ladderBoard) {
        playerNameList = participatingPlayerList.playerList()
                .stream()
                .map(Player::name)
                .collect(Collectors.toList());
        ladderBoardDto = new LadderBoardDto(ladderBoard);
    }

    public List<String> playerNameList() {
        return playerNameList;
    }

    public String ladderLine() {
        return ladderBoardDto.ladderLine();
    }

    public List<String> prizeNameList() {
        return ladderBoardDto.prizeNameList();
    }

}
