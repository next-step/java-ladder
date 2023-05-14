package ladder.domain.model.Param;

import ladder.domain.model.PlayerName;
import ladder.domain.model.PlayerNames;
import ladder.exception.PlayerCountArgumentException;
import ladder.exception.PlayerNameArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlayerNamesParam implements BaseParam {
    private static final String DELIMITER = ",";
    private static final String TRIM = " ";
    private static final int MINIMUM_NUMBER_OF_PEOPLE = 2;
    private String playersName;

    public PlayerNamesParam(String playersName) {
        if (playersName.isEmpty()) {
            throw new PlayerNameArgumentException("비어 있는 값을 입력하였습니다.");
        }
        this.playersName = playersName;
    }

    @Override
    public PlayerNames convertParamToModel() {
        List<String> playersNames = Arrays.stream(playersName.replaceAll(TRIM, "")
                .split(DELIMITER)).collect(Collectors.toList());

        if (isSmallerThanMinimum(playersNames.size())) {
            throw new PlayerCountArgumentException("최소인원 보다 작습니다.");
        }

        playersNames = fillOrRightAlign(playersNames);

        return new PlayerNames(playersNames.stream()
                .map(name -> new PlayerName(name))
                .collect(Collectors.toList()));
    }

    boolean isSmallerThanMinimum(int count) {
        return count < MINIMUM_NUMBER_OF_PEOPLE;
    }

    List<String> fillOrRightAlign(List<String> playersNames) {
        return playersNames.stream()
                .map(name -> name.length() < 5 ? String.format("%5s", name) : name)
                .collect(Collectors.toList());
    }
}
