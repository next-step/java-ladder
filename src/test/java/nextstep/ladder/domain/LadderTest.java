package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("사다리 생성")
    void initLadder() {
        String names = "java,study,game";
        InputUsers inputUsers = InputUsers.createInputUsers(names);
        Height height = Height.from(3);
        Users users = Users.createUsers(inputUsers);

        Ladder ladder = Ladder.initLadder(users, height);

        assertThat(ladder.getLines().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("참가자의 마지막 사다리 인덱스 확인")
    void mappingResult() {
        Point point1 = Point.from(0, Direction.RIGHT);
        Point point2 = Point.from(1, Direction.LEFT);
        Point point3 = Point.from(2, Direction.FORWARD);
        Line line1 = Line.from(Arrays.asList(point1, point2, point3));

        Point point4 = Point.from(0, Direction.FORWARD);
        Point point5 = Point.from(1, Direction.RIGHT);
        Point point6 = Point.from(2, Direction.LEFT);
        Line line2 = Line.from(Arrays.asList(point4, point5, point6));

        Ladder ladder = Ladder.from(Arrays.asList(line1, line2));

        String names = "java,study,game";
        InputUsers inputUsers = InputUsers.createInputUsers(names);
        Users users = Users.createUsers(inputUsers);
        Map<User, Integer> userMap = users.mapUserIndex();

        Map<User, Integer> newUserMap = ladder.matchLadder(userMap);

        Map<User, Integer> answerMap = new HashMap<>();

        List<User> userList = users.getUsers();
        answerMap.put(userList.get(0), 2);
        answerMap.put(userList.get(1), 0);
        answerMap.put(userList.get(2), 1);

        assertThat(newUserMap).isEqualTo(answerMap);

    }

}
