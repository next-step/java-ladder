package nextstep.step2.vo;

import nextstep.step2.domain.Line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private static String EMPTY_MESSAGE = "Line 은 최대 한줄 이상입니다.";

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static final Lines create(List<Line> lines) {

        if(lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }

        return new Lines(lines);
    }

    public static final Lines createWithHeightANdWidth(Height height, Width width, BooleanGenerateStrategy strategy) {
        List<Line> lines = IntStream.range(0, height.getHeight())
                .mapToObj(i -> Line.createWithWidth(width, strategy))
                .collect(Collectors.toList());
        return create(lines);
    }

    public boolean equalHeight(Height height) {
        return height.equals(Height.create(lines.size()));
    }

    public boolean equalWidth(Width width) {
        //생성자에서 lines는 최소 한줄 이상이 보장된다.
        return width.equals(Width.createWithLine(lines.get(0)));
    }
}
