package ladder.model;

public class LadderSlot {
    public static final int MAX_LEN = 5;

    private final String name;

    public LadderSlot(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }
        if (name.length() > MAX_LEN) {
            throw new IllegalArgumentException("이름은 " + MAX_LEN + "자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public boolean isName(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }
}
