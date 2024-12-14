package nextstep.ladder.domain;

import java.util.Objects;

public class Participant {
    public static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private final String result;

    private Position position;

    public Participant(String name) {
        this(name, 0);
    }

    public Participant(String name, int xAxis) {
        this(name, new Position(xAxis, 0), "");
    }

    public Participant(String name, Position position, String result) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 " + MAX_NAME_LENGTH + "글자입니다.");
        }

        this.name = name;
        this.position = position;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%-5s", name);
    }

    public int getPositionX() {
        return position.getX();
    }

    public int getPositionY() {
        return position.getY();
    }

    public Position getPosition() {
        return position;
    }

    public String getResult() {
        return result;
    }

    /* 이름으로만 같은 객체 간주 */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 같은 객체 참조 여부
        if (o == null || getClass() != o.getClass()) return false; // 클래스가 동일한지 확인
        Participant that = (Participant) o;
        return name.equals(that.name); // 이름이 동일한지 확인
    }

    @Override
    public int hashCode() {
        return name.hashCode(); // `name` 필드에 기반한 해시코드 반환
    }
}
