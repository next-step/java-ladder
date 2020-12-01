package ladder;


import ladder.ladderexceptions.InvalidUserNameException;

import java.util.Optional;

public class User {
    String name;

    public User(String inputName) {
        this.name = Optional.of(inputName)
                .filter(name -> !name.isEmpty() && name.length() <= 5)
                .orElseThrow(InvalidUserNameException::new);
    }
}
