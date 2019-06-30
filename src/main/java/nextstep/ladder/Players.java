package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private List<String> names;

    Player(String continuousName) {
        this.names = splitName(continuousName);
    }

    private List<String> splitName(String continuousName) {
        String[] names = continuousName.split(",");
        return Arrays.stream(names)
                .peek(name -> {
                    if (name.length()>5) {
                        throw new IllegalArgumentException("각 이름은 다섯 글자 내로 입력해주세요.");
                    }
                })
                .collect(Collectors.toList());
    }

    public int countOfPlayers() {
        return names.size();
    }
}
