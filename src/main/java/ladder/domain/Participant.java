package ladder.domain;

public class Participant {
    private final String name;
    private int location;

    public Participant(String name, int location) {
        this.name = validateParticipants(name);
        this.location = location;
    }

    public Boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return this.name;
    }

    private static String validateParticipants(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("참가자 이름은 다섯글자를 넘길 수 없습니다.");
        }

        return input;
    }

    public void updateLocation(Direction direction) {
        if (direction.moveLeft()) {
            this.location = location - 1;
        }

        if (direction.moveRight()) {
            this.location = location + 1;
        }
    }

    public int getLocation() {
        return this.location;
    }
}
