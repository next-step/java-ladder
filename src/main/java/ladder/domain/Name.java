package ladder.domain;

public class Name {
    public static final int MAX_NAME_SIZE = 5;
    public static final String BLANK = " ";
    private final String name;

    public Name(String name) {
        verifyLengthOfName(name);
        this.name = name;
    }

    private void verifyLengthOfName(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("이름은 최대5글자까지만 설정할 수 있습니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        while (sb.length() < MAX_NAME_SIZE) {
            sb.insert(0, BLANK);
        }
        return sb.toString();
    }

    public boolean isEqual(String selectedPlayer) {
        return this.name.equals(selectedPlayer);
    }
}
