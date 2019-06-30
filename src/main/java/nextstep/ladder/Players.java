package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> names;

    Players(String continuousName) {
        this.names = splitName(continuousName);
    }

    private List<Player> splitName(String continuousName) {
        String[] names = continuousName.replace(" ", "").split(",");
        return Arrays.stream(names)
                .peek(name -> {
                    if (name.length()>5) {
                        throw new IllegalArgumentException("각 이름은 다섯 글자 내로 입력해주세요.");
                    }
                })
                .map(name -> new Player(name))
                .collect(Collectors.toList());
    }

    public int countOfPlayer() {
        return names.size();
    }

    public String getFormattedName() {
        return this.names.stream()
                .map(name -> name.getName())
                .collect(Collectors.joining());
    }
}
