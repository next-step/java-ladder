package step2.util;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NoneConsecutiveSidelineGenerator extends SidelineGeneratorDecorator {

    public NoneConsecutiveSidelineGenerator(SidelineGenerator sidelineGenerator) {
        super(sidelineGenerator);
    }

    @Override
    public List<Boolean> generate() {
        return removeConsecutiveTrue(super.generate());
    }

    private List<Boolean> removeConsecutiveTrue(List<Boolean> current) {
        List<Boolean> previous = rightShiftOnceWithFalseFill(current);

        return IntStream.range(0, Math.min(previous.size(), current.size()))
                .mapToObj(i -> isNotConsecutiveTrue(previous.get(i), current.get(i)))
                .collect(Collectors.toList());
    }

    private List<Boolean> rightShiftOnceWithFalseFill(List<Boolean> generated) {
        return Stream.concat(Stream.of(false), generated.subList(0, generated.size() - 1).stream())
                .collect(Collectors.toList());
    }

    private Boolean isNotConsecutiveTrue(Boolean previous, Boolean current) {
        return !previous && current;
    }
}
