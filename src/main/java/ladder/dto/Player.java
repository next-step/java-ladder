package ladder.dto;

import java.util.List;

public class Player {
    private String name;
    private int location;

    public Player(String name) {
        validateName(name);
        this.name = name;
    }

    public Player(String name, int location) {
        validateName(name);
        validateLocation(location);
        this.name = name;
        this.location = location;
    }

    public static void validateName(String name) {
        if (name == null || name == "") {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자까지 가능합니다.");
        }
    }

    public static void validateLocation(int location) {
        if (location < 0) {
            throw new IllegalArgumentException("위치는 양수여야 합니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    public void moveLocationInLine(Line line) {
        if (isStartLocation()) {
            if (line.getPoint(this.location).isTrue()) {
                this.location = this.location + 1;
            }
            return;
        }

        if (isLastLocation(line)) {
            if (line.getPoint(this.location - 1).isTrue()) {
                this.location = this.location - 1;
            }
            return;
        }

        if (line.getPoint(this.location - 1).isTrue()) {
            this.location = this.location - 1;
            return;
        }

        if (line.getPoint(this.location).isTrue()) {
            this.location = this.location + 1;
            return;
        }
    }

    private boolean isStartLocation() {
        return this.location == 0;
    }

    private boolean isLastLocation(Line line) {
        return this.location == line.getLineSize();
    }

    public boolean equalsName(String name) {
        return this.name.equals(name);
    }
}
