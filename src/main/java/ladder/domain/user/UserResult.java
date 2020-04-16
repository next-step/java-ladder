package ladder.domain.user;

public class UserResult {
    private final String userName;
    private final int userPosition;

    public UserResult(String userName, int userPosition) {
        this.userName = userName;
        this.userPosition = userPosition;
    }

    public String name(){
        return userName;
    }
    public int position(){
        return userPosition;
    }


}
