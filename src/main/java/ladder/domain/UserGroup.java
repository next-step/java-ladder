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

    public Boolean compareCol(String name, int compareCol) {
        return userGroup.stream()
                .filter(user -> user.matchName(name))
                .findAny().orElseThrow(IllegalArgumentException::new)
                .getPosition()
                .matchCol(compareCol);
    }

    public Boolean compareNextCol(String name, int compareCol) {
        return userGroup.stream()
                .filter(user -> user.matchName(name))
                .findAny().orElseThrow(IllegalArgumentException::new)
                .getPosition()
                .matchNextCol(compareCol);
    }

    public void moveLeft(String name) {
        userGroup.stream()
                .filter(user -> user.matchName(name))
                .findAny().orElseThrow(IllegalArgumentException::new)
                .getPosition()
                .moveLeft();
    }

    public void moveRight(String name) {
        userGroup.stream()
                .filter(user -> user.matchName(name))
                .findAny().orElseThrow(IllegalArgumentException::new)
                .getPosition()
                .moveRight();
    }

    public void moveStraight(String name) {
        userGroup.stream()
                .filter(user -> user.matchName(name))
                .findAny().orElseThrow(IllegalArgumentException::new)
                .getPosition()
                .moveStraight();
    }

    public List<SingleUser> getUserGroup() {
        return userGroup;
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
