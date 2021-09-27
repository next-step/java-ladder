package nextstep.ladder.model.v1;

import java.util.Objects;

public class Label {
    public static final int MAX_LENGTH = 5;
    public static final Label EXIT = new Label("exit");
    public static final Label ALL = new Label("all");

    private final String label;

    public Label(String label) {
        if (label.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("label 길이는 5자를 넘을 수 없습니다!");
        }

        this.label = label;
    }

    public int length() {
        return label.length();
    }

    public boolean isExit() {
        return this.equals(EXIT);
    }

    public boolean isAll() {
        return this.equals(ALL);
    }

    @Override
    public String toString() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label1 = (Label) o;
        return label.equals(label1.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
