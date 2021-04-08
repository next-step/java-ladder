package step2.domain;

public class Height {
    private final int height;

    public Height(int height) {
        this.height = height;
    }

    public int height() {
        return this.height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height1 = (Height) o;
        return height == height1.height;
    }

}
