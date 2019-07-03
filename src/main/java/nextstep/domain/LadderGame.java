package nextstep.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderGame {
    private static final String SEPARATOR = ",";
    static final User DEFAULT_USER = new User("Bentley");

    private List<User> useGroup;
    private List<Line> ladder;
    private int maxHeight;

    public LadderGame(String userNames, int maxHeight) {
        String[] namesOfUser = checkNames(splitName(userNames));
        useGroup = new ArrayList<>();
        User userElement;

        for (String s : namesOfUser) {
            userElement = new User(s);
            useGroup.add(userElement);
        }

        this.maxHeight = maxHeight;
    }

    public List<User> getUseGroup() {
        return useGroup;
    }

    public List<Line> getLadder() {
        return ladder;
    }

    public User getUser(String name) {
        return useGroup.stream().filter(user -> user.matchName(name))
                .findAny()
                .orElse(DEFAULT_USER);
    }

    public void makeLadderLine() {
        ladder = new ArrayList<>();
        Line line;

        for (int i = 0; i < maxHeight; ++i) {
            line = new Line(useGroup.size());
            ladder.add(line);
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
