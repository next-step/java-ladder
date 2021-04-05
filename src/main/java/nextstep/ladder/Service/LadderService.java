package nextstep.ladder.Service;

import nextstep.ladder.domain.*;

import java.util.List;

public class LadderService {

    public static void run(Participants participants, Ladder ladder, LadderRewards ladderRewards) {
        // TODO 만들어진 ladder 가지고 결과 값 만들어내기

        List<User> users = participants.getUsers();
        List<String> ladderRewards1 = ladderRewards.getLadderRewards();
        for(User user : users) {
            Position position = user.position(); // 참여자 위치
            List<Line> lines = ladder.lines();

            for(Line line : lines) {
                System.out.println(position);
                position = line.move(position);
            }
            System.out.println("user : " + user + " :: POSITION : " + position.currentPosition() + " :: reward : " + ladderRewards1.get(position.currentPosition()));
        }
    }
}
