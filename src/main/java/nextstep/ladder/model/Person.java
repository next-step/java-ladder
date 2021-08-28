package nextstep.ladder.model;

public class Person {
    public static final int NAME_MAX_SIZE = 5;
    private String name;

    public Person(String name) {
        String trimmingName = name.trim();
        if (trimmingName.length() > NAME_MAX_SIZE || "".equals(trimmingName)) {
            throw new IllegalArgumentException("이름이 너무 깁니다. ");
        }
        this.name = trimmingName;
    }

    public String getName() {
        return name;
    }
}
