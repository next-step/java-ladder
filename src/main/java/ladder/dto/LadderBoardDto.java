package ladder.dto;

import ladder.domain.Ladder;
import ladder.domain.LadderBoard;

import java.util.List;
import java.util.stream.Collectors;

public class LadderBoardDto {

    private List<LineDto> lineList;

    private List<String> prizeNameList;

    public LadderBoardDto(LadderBoard ladderBoard) {
        this.lineList = ladderBoard.lineList()
                .stream().map(LineDto::new)
                .collect(Collectors.toList());
        this.prizeNameList = ladderBoard.ladderList()
                .stream().map(Ladder::prizeName)
                .collect(Collectors.toList());
    }

    public List<String> prizeNameList() {
        return prizeNameList;
    }

    public List<LineDto> lineList() {
        return lineList;
    }
}
