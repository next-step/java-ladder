package nextstep.ladder.domain;

import nextstep.ladder.dto.LadderGameDto;

public class LadderGame {

    public LadderGameDto play(Users users, Ladder ladder, InputResults inputresults) {
        LadderGameDto ladderGameDto = new LadderGameDto(users.toUserDtos(), ladder.toLadderDto());
        for (int i = 0; i < users.getUsers().size(); i++) {
            int x = ladder.getResultX(i);
            ladderGameDto.setUserResult(i, inputresults.getResult(x));
        }
        return ladderGameDto;
    }


}
