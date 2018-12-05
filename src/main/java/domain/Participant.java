package domain;

class Participant {

    private static final int LENGTH_BOUND = 5;
    private static final String OUTPUT_FORMAT = "%6s";

    private final String name;

    Participant(String name) {
        this.name = validate(name);
    }

    private String validate(String name) {
        if (name.length() > LENGTH_BOUND) {
            throw new IllegalArgumentException("참여자 명 5자 이내여야함.");
        }

        return name;
    }

    @Override
    public String toString() {
        return String.format(OUTPUT_FORMAT, name);
    }
}
