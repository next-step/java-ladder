package ladder.service;

import ladder.domain.*;
import ladder.dto.LineGenerateDto;
import ladder.factory.LadderFactory;
import ladder.factory.UserNameFactory;

import java.util.List;
import java.util.stream.Collectors;

public class LadderService {

    public Ladder getLadder(int numOfUser , LadderLength ladderLength){
        List<HorizontalLine> horizontalLines = LadderFactory.horizontalLines(new LineGenerateDto(numOfUser, ladderLength.getLength()));
        List<VerticalLine> verticalLines = LadderFactory.verticalLines(horizontalLines, numOfUser);
        return new Ladder(verticalLines , ladderLength);
    };

    public List<HorizontalPosition> getResultOfUser(Ladder ladder, Users users, String name) {
        List<User> foundUsers = UserNameFactory.getUserName(users,name).stream()
                .map(users::findUserByUsername)
                .collect(Collectors.toList());
        return ladder.play(foundUsers);
    }
}
