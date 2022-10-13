package ladder.service;

import ladder.model.HorizontalLine;
import ladder.model.LadderLength;
import ladder.model.LineUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLineGenerator implements LineGenerator {


    private final Supplier<Boolean> supplier;

    public RandomLineGenerator(Supplier<Boolean> supplier) {
        this.supplier = supplier;
    }

    @Override
    public List<HorizontalLine> generate(int numberOfUser, LadderLength length) {
        return IntStream.range(0, length.getLength())
                .mapToObj((idx) -> createHorizontalLine(numberOfUser))
                .collect(Collectors.toList());
    }

    private HorizontalLine createHorizontalLine(int numberOfUser) {
        List<LineUnit> units = new ArrayList<>();
        for (int i = 0; i < numberOfUser; i++) {
            units.add(getUnit(units, i));
        }
        return new HorizontalLine(units);
    }

    private LineUnit getUnit(List<LineUnit> units, int index) {
        LineUnit unit = new LineUnit();
        if (index == 0) {
            return unit;
        }
        LineUnit previousUnit = units.get(index - 1);
        if (!previousUnit.canAddNext() || supplier.get()) {
            return unit;
        }
        previousUnit.addNext(unit);
        return unit;
    }


}
