package ladder.domain;

import ladder.dto.LineGenerateDto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineGenerator {

    private final Supplier<Boolean> lineGeneratePolicy;

    public LineGenerator(Supplier<Boolean> lineGeneratePolicy) {
        this.lineGeneratePolicy = lineGeneratePolicy;
    }

    public List<HorizontalLine> generate(LineGenerateDto lineGenerateDto) {
        return IntStream.range(0, lineGenerateDto.getLadderLength())
                .mapToObj((idx) -> createHorizontalLine(lineGenerateDto.getNumOfUser()))
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
        if (!previousUnit.canAddNext() || lineGeneratePolicy.get()) {
            return unit;
        }
        previousUnit.addNext(unit);
        return unit;
    }


}
