package ladder.domain;

import java.util.*;

public class LadderGame {
    private static final String SEPARATOR = ",";
    static final GameUser DEFAULT_USER = new GameUser("Bentley");

    private List<GameUser> userGroup;
    private List<Line> ladderMap;

    public LadderGame(String userNames, int maxHeight) {
        String[] namesOfUser = checkNames(splitName(userNames));
        userGroup = new ArrayList<>();
        GameUser userElement;

        for (int i = 0; i < namesOfUser.length; ++i) {
            userElement = new GameUser(namesOfUser[i], i);
            userGroup.add(userElement);
        }

        makeLadderMap(maxHeight);
    }

    public List<GameUser> getUseGroup() {
        return userGroup;
    }

    public List<Line> getLadder() {
        return ladderMap;
    }

    public GameUser getUser(String name) {
        return userGroup.stream().filter(user -> user.matchName(name))
                .findAny()
                .orElse(DEFAULT_USER);
    }

    void makeLadderMap(int maxHeight) {
        ladderMap = new ArrayList<>();
        Line line;

        for (int i = 0; i < maxHeight; ++i) {
            line = new Line(userGroup.size());
            ladderMap.add(line);
        }
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
