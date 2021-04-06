package nextstep.ladder.generator;

import nextstep.ladder.domain.Bar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class DefaultLineGenerator implements LineGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public List<Bar> createLine(final int countOfPerson) {

        List<Bar> bars = new ArrayList<>(Arrays.asList(Bar.init()));
        // 초기 값 설정으로 1부터 시작
        IntStream.range(bars.size(), countOfPerson)
                .forEach(value -> addNextPoint(bars, value));

        return bars;
    }

    private void addNextPoint(final List<Bar> bars, final int value) {
        Bar bar = bars.get(value - 1);
        bars.add(point(bar.isExist()));
    }

    private Bar point(final boolean point) {
        if(point) {
            return Bar.init();
        }
        return Bar.valueOf(RANDOM.nextBoolean());
    }
}
