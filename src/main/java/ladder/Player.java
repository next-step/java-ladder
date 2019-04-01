package ladder;

public class Player {
    public static final String BLANK = " ";
    private final String name;

    public Player(String name) {
        verifyLenthOfName(name);
        this.name = name;
    }

    private void verifyLenthOfName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대5글자까지만 설정할 수 있습니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        while (sb.length() < 5) {
            sb.insert(0, BLANK);
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }
}
