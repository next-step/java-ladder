package ladder.domain;

import java.util.*;
import java.util.stream.IntStream;

public class LadderGame {
    private static final String SEPARATOR = ",";
    static final GameUser DEFAULT_USER = new GameUser("Bentley");

    private List<GameUser> userGroup;
    private List<Line> ladderMap;
    private List<GameReward> gameReward;

    public LadderGame(String userNames, String userReward, int maxHeight) {
        String[] namesOfUser = checkNames(splitName(userNames));
        userGroup = new ArrayList<>();
        GameUser userElement;

        for (int i = 0; i < namesOfUser.length; ++i) {
            userElement = new GameUser(namesOfUser[i], i);
            userGroup.add(userElement);
        }

        String[] namesOfReward = checkReward(splitName(userReward));
        gameReward = new ArrayList<>();
        GameReward gameRewardElement;

        for (int i = 0; i < namesOfReward.length; ++i) {
            gameRewardElement = new GameReward(namesOfReward[i], maxHeight, i);
            gameReward.add(gameRewardElement);
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

    public List<GameReward> getgameReward() {
        return gameReward;
    }

    void makeLadderMap(int maxHeight) {
        ladderMap = new ArrayList<>();
        Line line;

        for (int i = 0; i < maxHeight; ++i) {
            line = new Line(userGroup.size());
            ladderMap.add(line);
        }
    }

    public void startLadderGame() {
        GameResult.run(this, makeLadderMapArr());
        GameResult.getResult(gameReward,userGroup);
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

    private String[] checkReward(String[] inputStrings) {
        Arrays.stream(inputStrings)
                .filter(inputString -> inputString.isEmpty() || inputString.equals(" ")
                        || inputString.equals("\n"))
                .forEach(inputString -> {
                    throw new IllegalArgumentException("입력값이 잘못되었습니다. 실행 결과를 다시 한번 입력해주세요.");
                });

        return inputStrings;
    }
    // listArray를 array로 변환 (게임 결과 확인을 위해서)
    private Boolean[][] makeLadderMapArr() {
        Line[] ladderArr = ladderMap.toArray(new Line[ladderMap.size()]);
        Boolean[][] map = new Boolean[ladderMap.size()][userGroup.size()];

        for (int i = 0; i < ladderArr.length; ++i) {
            map[i] = ladderArr[i].getPoints().toArray(new Boolean[userGroup.size()]);
        }

        return map;
    }
}
