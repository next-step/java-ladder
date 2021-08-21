package nextstep.ladder.domain.user;

public class User {
    private UserName userName;
    private int indexOfColumnLine;

    public User(UserName userName) {
        this.userName = userName;
    }

    public User(UserName userName, int indexOfColumnLine) {
        this.userName = userName;
        this.indexOfColumnLine = indexOfColumnLine;
    }

    public User(String userName, int indexOfColumnLine) {
        this.userName = new UserName(userName);
        this.indexOfColumnLine = indexOfColumnLine;
    }

    public String getName() {
        return userName.getUserName();
    }

    public int getIndexOfColumnLine() {
        return indexOfColumnLine;
    }

    public void move(int indexOfColumnLine) {
        this.indexOfColumnLine = indexOfColumnLine;
    }
}
