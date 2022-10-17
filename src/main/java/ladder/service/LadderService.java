package ladder.service;

import ladder.domain.*;
import ladder.dto.LineGenerateDto;
import ladder.factory.LadderFactory;

import java.util.List;

public class LadderService {

    public Ladder getLadder(Users users, LadderLength ladderLength){
        List<HorizontalLine> horizontalLines = LadderFactory.horizontalLines(new LineGenerateDto(users.size(), ladderLength.getLength()));
        List<VerticalLine> verticalLines = LadderFactory.verticalLines(horizontalLines, users.size());
        return new Ladder(verticalLines , ladderLength);
    };
}
