package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(List<String> names) {
        prizes = names.stream()
                .map(name -> new Prize(name))
                .collect(Collectors.toList());
    }

    public Prize get(int index){
        return prizes.get(index);
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
