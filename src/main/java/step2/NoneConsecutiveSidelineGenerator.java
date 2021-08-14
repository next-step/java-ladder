package step2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NoneConsecutiveSidelineGenerator extends SidelineGeneratorDecorator {

    public NoneConsecutiveSidelineGenerator(SidelineGenerator sidelineGenerator) {
        super(sidelineGenerator);
    }

    @Override
    public List<Boolean> generate(int n) {
        return removeConsecutiveTrue(super.generate(n));
    }

    private List<Boolean> removeConsecutiveTrue(List<Boolean> generated) {
        List<Boolean> generatedPrevious = rightShiftBooleanList(generated);

        return IntStream.range(0, Math.min(generatedPrevious.size(), generated.size()))
                .mapToObj(i -> intToBooleanWithPrevious(generatedPrevious.get(i), generated.get(i)))
                .collect(Collectors.toList());
    }

    private List<Boolean> rightShiftBooleanList(List<Boolean> generated) {
        return Stream.concat(Stream.of(false), generated.stream().limit(2))
                .collect(Collectors.toList());
    }

    private Boolean intToBooleanWithPrevious(Boolean previous, Boolean current) {
        return !previous && current;
    }
}
