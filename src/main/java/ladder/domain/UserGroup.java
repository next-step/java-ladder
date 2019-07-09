package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserGroup {
    private static final String SEPARATOR = ",";

    private List<SingleUser> userGroup;

    public UserGroup(String name) {
        String[] namesOfUser = checkNames(splitName(name));
        userGroup = new ArrayList<>();
        SingleUser userElement;

        for (int i = 0; i < namesOfUser.length; ++i) {
            userElement = new SingleUser(namesOfUser[i], i);
            userGroup.add(userElement);
        }
    }

    public void playLadderGame(LadderFactory ladderFactory, Boolean[][] ladderMap, String requestName) {
        int moveFlag = 0;

        for (int i = 0; i < ladderFactory.getLadder().size(); ++i) {
            for (int j = 1; j < userGroup.size(); ++j) {
                // 좌측으로 움직이는 조건
                if (this.compareCol(requestName, j) && ladderMap[i][j].equals(Boolean.TRUE)) {
                    this.moveLeft(requestName);
                    moveFlag += 1;
                    break;
                }
                // 좌측으로 움직이는 조건
                if (this.compareNextCol(requestName, j) && ladderMap[i][j].equals(Boolean.TRUE)) {
                    this.moveRight(requestName);
                    moveFlag += 1;
                    break;
                }
            }
            // 좌 우측 움직이 없을때 직진
            if (moveFlag == i) {
                this.moveStraight(requestName);
                moveFlag += 1;
            }
        }
    }

    public List<SingleUser> getUserGroup() {
        return userGroup;
    }

    private Boolean compareCol(String name, int compareCol) {
        return userGroup.stream()
                .filter(user -> user.matchName(name))
                .findAny().orElseThrow(IllegalArgumentException::new)
                .getPosition()
                .matchCol(compareCol);
    }

    private Boolean compareNextCol(String name, int compareCol) {
        return userGroup.stream()
                .filter(user -> user.matchName(name))
                .findAny().orElseThrow(IllegalArgumentException::new)
                .getPosition()
                .matchNextCol(compareCol);
    }

    private void moveLeft(String name) {
        userGroup.stream()
                .filter(user -> user.matchName(name))
                .findAny().orElseThrow(IllegalArgumentException::new)
                .getPosition()
                .moveLeft();
    }

    private void moveRight(String name) {
        userGroup.stream()
                .filter(user -> user.matchName(name))
                .findAny().orElseThrow(IllegalArgumentException::new)
                .getPosition()
                .moveRight();
    }

    private void moveStraight(String name) {
        userGroup.stream()
                .filter(user -> user.matchName(name))
                .findAny().orElseThrow(IllegalArgumentException::new)
                .getPosition()
                .moveStraight();
    }

    private String[] splitName(String names) {
        return names.split(SEPARATOR);
    }

    private String[] checkNames(String[] inputStrings) {
        Arrays.stream(inputStrings)
                .filter(inputString -> inputString.isEmpty() || inputString.equals(" ")
                        || inputString.equals("\n") || inputString.length() > 5)
                .forEach(inputString -> {
                    throw new IllegalArgumentException("입력값이 잘못되었습니다. 사람 이름을 다시 한번 입력해주세요.");
                });

        return inputStrings;
    }
}
