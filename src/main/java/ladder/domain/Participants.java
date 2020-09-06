package ladder.domain;

import java.util.List;

import ladder.util.StringUtils;

public class Participants {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int INVALID_INDEX = -1;

    private static final String ERR_TOO_LONG_NAME = "한 사람당 이름은 5자까지만 입력해주세요.";
    private static final String ERR_INVALID_PLAYER_NAME = "존재하지 않는 참여자입니다.";

    private final List<String> names;

    public Participants(String nameStr) {
        this.names = StringUtils.splitStringToList(nameStr);
        verifyNameLength(names);
    }

    private void verifyNameLength(List<String> names) {
        if (hasLongName(names)) {
            throw new IllegalArgumentException(ERR_TOO_LONG_NAME);
        }
    }

    private boolean hasLongName(List<String> names) {
        return names.stream()
                .anyMatch(name -> name.length() > MAXIMUM_NAME_LENGTH);
    }

    public List<String> getNames() {
        return names;
    }

    public int getPlayerIndex(String playerName) {

        int index = names.indexOf(playerName);

        if (index == INVALID_INDEX) {
            throw new IllegalArgumentException(ERR_INVALID_PLAYER_NAME);
        }

        return index;
    }

    public int getPlayerCount() {
        return names.size();
    }
}
