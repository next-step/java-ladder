package dto;

public class Player {

    public final static int NAME_LENGTH = 5;
    private String name;

    public Player(String name) {
        if(name.length() > NAME_LENGTH){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
