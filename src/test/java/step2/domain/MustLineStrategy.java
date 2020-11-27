package step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MustLineStrategy implements LineStrategy {

    private boolean line;

    @Override
    public List<Boolean> createLine(int personCount) {
        return IntStream.range(0, personCount)
                .mapToObj(i -> getLine())
                .collect(Collectors.toList());
    }

    private boolean getLine() {
        line = !line;
        return line;
    }

}
