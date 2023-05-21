package ladder.domain.model.Param;

import ladder.Utils;
import ladder.domain.model.PlayerName;
import ladder.domain.model.PlayerNames;
import ladder.exception.PlayerCountArgumentException;
import ladder.exception.PlayerNameArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PlayerNamesParam {
    private static final String DELIMITER = ",";
    private static final String TRIM = " ";
    private static final int MINIMUM_NUMBER_OF_PEOPLE = 2;
    private static final int MAX_NAME_SIZE = 5;

    private String playersName;

    public PlayerNamesParam(String playersName) {
        if (playersName.isEmpty()) {
            throw new PlayerNameArgumentException("비어 있는 값을 입력하였습니다.");
        }
        this.playersName = playersName;
    }

    public PlayerNames convertParamToModel() {
        List<String> playersNames = Arrays.stream(playersName.replaceAll(TRIM, "")
                .split(DELIMITER)).collect(Collectors.toList());

        if (isSmallerThanMinimum(playersNames.size())) {
            throw new PlayerCountArgumentException("최소인원 보다 작습니다.");
        }
        playersNames = Utils.fillOrRightAlign(playersNames);

        List<String> finalPlayersNames = playersNames;
        Supplier<PlayerNames> supplier = () -> new PlayerNames(finalPlayersNames.stream()
                .map(name -> new PlayerName(name))
                .collect(Collectors.toList()));

        return supplier.get();

    }

    boolean isSmallerThanMinimum(int count) {
        return count < MINIMUM_NUMBER_OF_PEOPLE;
    }

    List<String> fillOrRightAlign(List<String> playersNames) {
        return playersNames.stream()
                .map(name -> name.length() < MAX_NAME_SIZE ? String.format("%5s", name) : name)
                .collect(Collectors.toList());
    }
}
