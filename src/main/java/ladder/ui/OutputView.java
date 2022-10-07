package ladder.ui;

import ladder.model.LineUnit;
import ladder.model.User;
import ladder.model.Users;

public class OutputView {

    private static final int INTERVAL = 6;
    private static final String LADDER_WITH_NO_SPACE = " ";
    private static final String HORIZONTAL_UNIT = "-";
    private static final String VERTICAL_UNIT = "|";

    public static void printLadder(Users users, Integer lineLength) {
        printName(users);
        System.out.println();
        printLine(users,lineLength);
    }

    private static void printName(Users users) {
        for(int i = 0; i < users.size() ; i++){
            String username = getNameOfUser(users.getUsers().get(i));
            if ( i == 0 ){
                System.out.print(username);
                continue;
            }
            System.out.print(addDelimiter(INTERVAL - username.length(), LADDER_WITH_NO_SPACE) + username);
        }
    }

    private static void printLine(Users users, int length) {
        for (int i = 0; i  < length; i ++){
            for (int j = 0; j < users.size() ; j++){
                StringBuilder stringBuilder = new StringBuilder();
                User user = users.getUsers().get(j);
                String username = getNameOfUser(user);
                LineUnit unit = user.getVerticalLine().getLineUnits().get(i);
                if (j == 0 ){
                    stringBuilder.append(addDelimiter(username.length(),LADDER_WITH_NO_SPACE) + VERTICAL_UNIT);
                }else{
                    if (unit.hasPrevious()) {
                        stringBuilder.append(addDelimiter(INTERVAL-1, HORIZONTAL_UNIT) + VERTICAL_UNIT);
                    }else{
                        stringBuilder.append(addDelimiter(INTERVAL-1,LADDER_WITH_NO_SPACE) + VERTICAL_UNIT);
                    }
                }
                System.out.print(stringBuilder);
            }
            System.out.println("");
        }
    }

    private static String addDelimiter(int length ,String delimiter){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < length ; i ++){
            stringBuilder.append(delimiter);
        }
        return stringBuilder.toString();
    }

    private static String getNameOfUser(User user){
        return user.getName().getName();
    }
}
