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

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(obj);
    }

    public String getName() {
        return name;
    }
}
