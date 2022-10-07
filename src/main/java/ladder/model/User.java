package ladder.model;

public class User {
    private final UserName name;

    private VerticalLine verticalLine;
    public User(UserName name) {
        this.name = name;
    }

    public void addLine(VerticalLine line){
        this.verticalLine = line;
    }

    public boolean hasLine(){
        return verticalLine != null;
    }

    public UserName getName() {
        return name;
    }
}
