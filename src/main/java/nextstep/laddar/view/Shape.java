package nextstep.laddar.view;

import nextstep.laddar.User;

public enum Shape {
    BLANK(" "),
    HORIZONTAL_LINE("-"),
    VERTICAL_LINE("|"),
    ;

    private final String shape;

    Shape(String shape) {
        this.shape = shape;
    }

    public String makePrintShape(int repeat) {
        return shape.repeat(repeat);
    }
}
