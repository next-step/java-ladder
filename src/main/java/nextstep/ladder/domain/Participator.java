package nextstep.ladder.domain;

import java.util.Objects;

public class Participator {

    private final String name;
    private int location;

    public Participator(String name, int location) {
        if (name.length() > 5) {
            name = name.substring(0, 5);
        }
        this.name = name;
        this.location = location;
    }

    /**
     * 참가자의 위치를 i라고 한다면 사다리 상태는 i-1, i 2개를 확인해야 합니다.
     * 1. i-1 이 연결되어 있다면 참가자의 위치는 i-1 이 됩니다.
     * 2. i 가 연결되어 있다면 참가자의 위치는 i+1 이 됩니다.
     * 3. 둘 다 연결되어 있지 않다면 참가자의 위치는 i가 됩니다.
     */
    public void goLadderOneLine(Line line) {
        if (isLeftLadderConnected(line)) {
            location--;
            return;
        }
        if (isRightLadderConnected(line)) {
            location++;
        }
    }

    private boolean isLeftLadderConnected(Line line) {
        return location != 0 && line.isConnected(location - 1);
    }

    private boolean isRightLadderConnected(Line line) {
        return location != line.getSize() && line.isConnected(location);
    }

    public String makeFullName() {
        if (name.length() == 5) {
            return " " + name;
        }

        String tempName = "     " + name + " ";
        return tempName.substring(tempName.length() - 6);
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participator that = (Participator) o;
        return location == that.location && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}
