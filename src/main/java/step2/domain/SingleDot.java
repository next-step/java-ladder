package step2.domain;

class SingleDot implements Dot {
    private final String dot;

    public SingleDot() {
        this("-");
    }

    SingleDot(final String dot) {
        if (dot == null) {
            throw new IllegalArgumentException();
        }
        if (dot.length() != 1) {
            throw new IllegalArgumentException();
        }
        this.dot = dot;
    }

    @Override
    public String print() {
        return dot;
    }
}
