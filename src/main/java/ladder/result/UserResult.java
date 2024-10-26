package ladder.result;


import ladder.line.move.Position;
import ladder.name.Name;

public class UserResult {
    private Name name;
    private Position position;

    public UserResult(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public boolean isNameEqualTo(Name name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

}
