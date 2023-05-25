package ladder.model;

import ladder.common.InputMessages;

public class Player {

    private int sequence;
    private String name;

    public Player(int sequence, String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException(InputMessages.MAXIMUM_PLAYER_NAME_LENGTH);
        }
        this.name = name;
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public int getSequence() {
        return sequence;
    }
}
