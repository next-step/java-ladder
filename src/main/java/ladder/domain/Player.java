package ladder.domain;

import java.util.regex.Pattern;

public class Player {
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
            throw new IllegalArgumentException("이름은 최대 5글자입니다");
        }
    }

    private void checkNameBlank(String name){
        if (!PATTERN_NON_BLANK.matcher(name).matches()) {
            throw new IllegalArgumentException("이름은 공백을 포함할 수 없습니다");
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i <= MAX_NAME_LENGTH - name.length(); i++){
            result.append(BLANK);
        }
        result.append(name);
        return result.toString();
    }
}
