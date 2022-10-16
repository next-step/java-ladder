package ladder.domain;

import ladder.dto.LineGenerateDto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLineGenerator implements LineGenerator {


    @Override
    public List<HorizontalLine> generate(LineGenerateDto lineGenerateDto, Supplier<Boolean> lineGeneratePolicy) {
        return IntStream.range(0, lineGenerateDto.getLadderLength())
                .mapToObj((idx) -> createHorizontalLine(lineGenerateDto.getNumOfUser(), lineGeneratePolicy))
                .collect(Collectors.toList());
    }

    private HorizontalLine createHorizontalLine(int numberOfUser, Supplier<Boolean> lineGeneratePolicy) {
        List<LineUnit> units = new ArrayList<>();
        for (int i = 0; i < numberOfUser; i++) {
            units.add(getUnit(units, i, lineGeneratePolicy));
        }
        return new HorizontalLine(units);
    }

    private LineUnit getUnit(List<LineUnit> units, int index, Supplier<Boolean> lineGeneratePolicy) {
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
