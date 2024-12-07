package ladder.domain.engine;

public class PlayerName extends Name {
    public PlayerName(String value) {
        super(value);
    }

    @Override
    public int length() {
        return name.length();
    }

    @Override
    public String name() {
        return name;
    }
}
