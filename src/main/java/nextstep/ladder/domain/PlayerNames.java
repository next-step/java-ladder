package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNames {
    private List<PlayerName> values;

    private PlayerNames(List<PlayerName> values) {
        this.values = new ArrayList<>(values);
    }

    public static PlayerNames create(String inputValue) {
        List<PlayerName> values = Arrays.stream(inputValue.trim().split(","))
                .map(PlayerName::new)
                .collect(Collectors.toList());
        return new PlayerNames(values);
    }

    public int size() {
        return this.values.size();
    }
}
