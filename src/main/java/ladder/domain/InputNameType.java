package ladder.domain;

public enum InputNameType {
    ALL,
    EACH;

    private static final String ALL_DESC = "all";

    public static InputNameType of(String name) {
        if (ALL_DESC.equals(name)) {
            return ALL;
        }

        return EACH;
    }
}
