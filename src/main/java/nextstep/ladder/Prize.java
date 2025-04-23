package nextstep.ladder;

public class Prize {
    private final String name;

    public Prize(String name) {
        validName(name);
        this.name = name;
    }

    private static void validName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("상품 이름은 비어 있을 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

}
