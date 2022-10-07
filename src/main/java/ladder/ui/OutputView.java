package ladder.ui;

import ladder.model.User;
import ladder.model.Users;

public class OutputView {

    private static final int INTERVAL = 6;
    public static void printLadder(Users users, Integer lineLength) {
        for(int i = 0 ; i < users.size() ; i++){
            if ( i == 0 ){
                System.out.print(getNameOfUser(users.getUsers().get(i)));
                continue;
            }
            System.out.print(addEmptySpace(getNameOfUser(users.getUsers().get(i))));
        }
    }

    private static String addEmptySpace(String name){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < INTERVAL - name.length() ; i ++){
            stringBuilder.append(" ");
        }
        return stringBuilder + name;
    }

    private static String getNameOfUser(User user){
        return user.getName().getName();
    }
}
