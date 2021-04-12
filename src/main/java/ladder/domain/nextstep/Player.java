package ladder.domain.nextstep;

import java.util.Objects;
import java.util.regex.Pattern;

public class Player {
    private static final String MESSAGE_MAX_NAME_LENGTH = "이름은 최대 5글자입니다.";
    private static final String MESSAGE_NAME_NON_BLANK = "이름은 공백을 포함할 수 없습니다.";
    private static final int MAX_NAME_LENGTH = 5;
    private static final String BLANK = " ";
    private final static Pattern PATTERN_NON_BLANK = Pattern.compile("\\A\\S+\\Z");
    private final String name;

    public Player(String name){
        checkNameBlank(name);
        checkNameLength(name);
        this.name = name;
    }

    private void checkNameLength(String name){
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MESSAGE_MAX_NAME_LENGTH);
        }
    }

    private void checkNameBlank(String name){
        if (!PATTERN_NON_BLANK.matcher(name).matches()) {
            throw new IllegalArgumentException(MESSAGE_NAME_NON_BLANK);
        }
    }

    public String name(){
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Player otherPlayer = (Player) other;
        return Objects.equals(name, otherPlayer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
