package nextstep.step3.domain;

public class User {
    private String userName;
    private String result;

    public User(String userName, String result) {
        this.userName = userName;
        this.result = result;
    }

    public String getUserName() {
        return userName;
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        User objUser = (User) obj;
        return this.userName.equals(objUser.userName) && this.result.equals(objUser.result);
    }
}
