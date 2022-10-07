package ladder.model;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users(List<User> users){
        this.users = users;
    }

    public static Users createUsersWithName(List<String> names){
        return new Users(names.stream()
                .map(UserName::new)
                .map(User::new)
                .collect(Collectors.toList()));
    }

    public int size(){
        return this.size();
    }

    public void addLine(List<HorizontalLine> horizontalLine) {
        for (int i = 0 ; i < this.users.size(); i++){
            users.get(i).addLine(new VerticalLine(getVerticalLine(horizontalLine, i)));
        }
    }

    private List<LineUnit> getVerticalLine(List<HorizontalLine> horizontalLine, int index) {
        List<LineUnit> verticalLine = new ArrayList<>();
        for (int j = 0; j < horizontalLine.size() ; j++){
            HorizontalLine line = horizontalLine.get(j);
            validateLine(line);
            LineUnit lineUnit = line.getUnits().get(index);
            verticalLine.add(lineUnit);
        }
        return verticalLine;
    }

    private void validateLine(HorizontalLine line) {
        if (this.users.size() != line.getUnits().size()){
            throw new IllegalArgumentException("유효하지 않은 행 라인입니다.");
        }
    }

    public boolean hasLine() {
        return !this.users.stream().anyMatch(user-> !user.hasLine());
    }
}
