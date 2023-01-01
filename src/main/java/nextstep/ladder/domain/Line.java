package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> lines = new ArrayList<>();
    private Random random = new Random();

    public void lineGenerate(int memberCount){
        IntStream.range(0, memberCount - 1)
                .forEach(i -> lines.add(random.nextBoolean()));
    }

}
