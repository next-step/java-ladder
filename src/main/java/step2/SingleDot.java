package step2;

class SingleDot implements Dot {
    private final String dot;

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
