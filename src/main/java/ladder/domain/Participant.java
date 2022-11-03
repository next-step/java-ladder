package ladder.domain;

import java.util.Objects;

public class Participant {
    private final static int MAX_NAME_LENGTH = 5;

    private String name;

    public Participant(String name) {
        if(Objects.isNull(name) || name.isEmpty()){
            throw new IllegalArgumentException("participant name cannot be empty");
        }
        if(name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("participant name length cannot be longer than 5");
        }
        this.name = name;
    }
}
