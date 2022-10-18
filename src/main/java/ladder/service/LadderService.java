package ladder.service;

import ladder.domain.*;
import ladder.dto.LineGenerateDto;
import ladder.dto.ResultDto;
import ladder.factory.LadderFactory;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LadderService {

    public Ladder getLadder(int numOfUser , LadderLength ladderLength){
        LineGenerator lineGenerator = new LineGenerator(() -> new Random().nextBoolean());
        List<HorizontalLine> horizontalLines = LadderFactory.horizontalLines(new LineGenerateDto(numOfUser, ladderLength.getLength()) , lineGenerator);
        List<VerticalLine> verticalLines     = LadderFactory.verticalLines(horizontalLines, numOfUser);
        return new Ladder(verticalLines , ladderLength);
    };

    public ResultDto getResultOfUser(Ladder ladder, List<User> foundUsers, LadderResult ladderResult) {
        List<String> results = getResultOfPosition(ladder, ladderResult, foundUsers);
        return new ResultDto(foundUsers,results);
    }

    private List<String> getResultOfPosition(Ladder ladder, LadderResult ladderResult, List<User> foundUsers) {
        List<HorizontalPosition> positions = getStartPosition(foundUsers);

        return  ladder.play(positions)
                .stream()
                .map(ladderResult::result)
                .collect(Collectors.toList());
    }

    private List<HorizontalPosition> getStartPosition(List<User> foundUsers) {
        List<HorizontalPosition> positions = foundUsers.stream()
                .map(User::getPosition)
                .collect(Collectors.toList());
        return positions;
    }


}
