package nextstep.step3.domain;

public class User {
    private String userName;
    private int destinationIndex;

    public User(String userName, int destinationIndex) {
        this.userName = userName;
        this.destinationIndex = destinationIndex;
    }

    public String getUserName() {
        return userName;
    }

    public int getDestinationIndex() {
        return destinationIndex;
    }
}
