package ladder.dto;

import ladder.domain.LadderBoard;
import ladder.domain.Player;
import ladder.domain.PlayerList;

import java.util.List;
import java.util.stream.Collectors;

public class LadderBoardDto {

    private List<String> playerNameList;

    private List<LineDto> lineList;

    private static final String LINE_BREAK = "\n";

    public LadderBoardDto(PlayerList participatingPlayerList, LadderBoard ladderBoard) {
        playerNameList = participatingPlayerList.playerList()
                .stream()
                .map(Player::name)
                .collect(Collectors.toList());
        this.lineList = ladderBoard.lineList()
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
