package ladder.domain;

public class Name {
    private final String name;

    public Name(String name) {
        String normalizedName = name.trim();
        validateName(normalizedName);
        this.name = normalizedName;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public boolean equals(String target) {
        return name.equals(target);
    }
}
