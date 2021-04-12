package nextstep.ladder.domain;

import java.util.Objects;

public class Player {
    public static final String CHECK_NAME_LENGTH = "이름이 5자를 초과하는지 확인해주세요.";
    public static final int NAME_LENGTH_MIN = 5;
    private final String name;

    public Player(String name) {
        checkNameLength(name);
        this.name = addBlankInName(name);;
    }

    private void checkNameLength(String name) {
        if (name.length() > NAME_LENGTH_MIN) {
            throw new IllegalArgumentException(CHECK_NAME_LENGTH);
        }
    }

    private String addBlankInName(String name) {
        int nameLength = name.length();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < NAME_LENGTH_MIN - nameLength; i++) {
            stringBuilder.append(" ");
        }

        return name + stringBuilder.toString();
    }

    public String name() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
