package nextstep.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public enum LineValidator {

    OVERLAP(points -> IntStream.range(Constants.FIRST_POINT_INDEX, points.size() - 1)
            .mapToObj(i -> new LineValidateOverlapDto(points.get(i), points.get(i + 1)).isOverlap())
            .anyMatch(Boolean::booleanValue))
    ;

    private LineValidate lineValidate;

    LineValidator(LineValidate lineValidate) {
        this.lineValidate = lineValidate;
    }

    public boolean validate(List<Boolean> points) {
        return lineValidate.validate(points);
    }

    public static boolean validateNotOverlap(List<Boolean> points) {
        return Arrays.stream(values())
                .noneMatch(lineValidator -> lineValidator.validate(points));
    }

    private static class LineValidateOverlapDto {

        private Boolean leftTransverseBar;
        private Boolean rightTransverseBar;

        public LineValidateOverlapDto(Boolean leftTransverseBar, Boolean rightTransverseBar) {
            this.leftTransverseBar = leftTransverseBar;
            this.rightTransverseBar = rightTransverseBar;
        }

        public boolean isOverlap() {
            return leftTransverseBar && rightTransverseBar;
        }

    }

    private static class Constants {
        public static final int FIRST_POINT_INDEX = 0;
    }

}
