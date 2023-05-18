package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Participants {
    private final List<String> names;

    public Participants(List<String> names) {
        this.names = names;
    }

    public int getIndexOf(String name) {
        return IntStream.range(0, names.size())
                .filter(i -> names.get(i).equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이름입니다."));
    }
}
