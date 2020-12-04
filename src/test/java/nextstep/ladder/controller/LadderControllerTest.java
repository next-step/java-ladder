package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class LadderControllerTest {

    LadderController controller;

    @Test
    @DisplayName("참가자 리스트 생성 기능")
    void initUsers() {
        String names = "java,study,game";
        InputUsers inputUsers = new InputUsers(names);
        controller = new LadderController();

        List<User> userList = new ArrayList<>();
        for(String name : names.split(",")) {
            userList.add(new User(name));
        }

        Users users = controller.initUsers(inputUsers);
        assertThat(users).isEqualTo(new Users(userList));
    }

    @Test
    @DisplayName("사다리 생성 기능")
    void initLadder() {
        Users users = new Users(Arrays.asList(new User("java"), new User("study")));
        Height height = new Height(3);
        controller = new LadderController();
        Ladder ladder = controller.initLadder(users, height);

        assertThat(ladder.getLines().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("라인 생성 기능")
    void initLine() {
        Users users = new Users(Arrays.asList(new User("java"), new User("study")));
        controller = new LadderController();
        Line line = controller.initLine(users);

        assertThat(line.getPoints().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("첫 인덱스일 때, Direction 오른쪽")
    void firstIndexRight() {
        controller = new LadderController();

        Direction direction = controller.decideDirection(null, 0, () -> 1);

        assertThat(direction).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("첫 인덱스일 때, Direction 직진")
    void firstIndexForward() {
        controller = new LadderController();

        Direction direction = controller.decideDirection(null, 0, () -> 0);

        assertThat(direction).isEqualTo(Direction.FORWARD);
    }

    @Test
    @DisplayName("이전 direction이 오른쪽일 때, 다음 direction 왼쪽")
    void nextDirectionLeft() {
        controller = new LadderController();

        Direction direction = controller.decideDirection(Direction.RIGHT, 1, () -> 3);

        assertThat(direction).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("이전 direction이 왼쪽일 때, 다음 direction 직진")
    void leftDirectionForward() {
        controller = new LadderController();

        Direction direction = controller.decideDirection(Direction.LEFT, 2, () -> 0);

        assertThat(direction).isEqualTo(Direction.FORWARD);
    }

    @Test
    @DisplayName("이전 direction이 왼쪽일 때, 다음 direction 오른쪽")
    void leftDirectionRight() {
        controller = new LadderController();

        Direction direction = controller.decideDirection(Direction.LEFT, 2, () -> 1);

        assertThat(direction).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("이전 direction이 왼쪽일 때, 마지막 인덱스인 경우 직진")
    void leftDirectionLastIndex() {
        controller = new LadderController();

        Direction direction = controller.decideDirection(Direction.LEFT, -1, () -> 0);

        assertThat(direction).isEqualTo(Direction.FORWARD);
    }

    @Test
    @DisplayName("이전 direction이 직진일 때, 다음 direction 직진")
    void forwardDirectionForward() {
        controller = new LadderController();

        Direction direction = controller.decideDirection(Direction.FORWARD, 2, () -> 0);

        assertThat(direction).isEqualTo(Direction.FORWARD);
    }

    @Test
    @DisplayName("이전 direction이 직진일 때, 다음 direction 오른쪽")
    void forwardDirectionRight() {
        controller = new LadderController();

        Direction direction = controller.decideDirection(Direction.FORWARD, 2, () -> 1);

        assertThat(direction).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("이전 direction이 직진일 때, 마지막 인덱스인 경우 직진")
    void forwardDirectionLastIndex() {
        controller = new LadderController();

        Direction direction = controller.decideDirection(Direction.FORWARD, -1, () -> 0);

        assertThat(direction).isEqualTo(Direction.FORWARD);
    }

}