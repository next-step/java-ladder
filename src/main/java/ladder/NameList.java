package ladder;

import ladder.utils.StringToNameListConverter;

import java.util.List;

public class NameList {
    private List<String> nameList;

    public NameList(String nameList) {
        this.nameList = StringToNameListConverter.toList(nameList);
    }

    public int numOfName() {
        return nameList.size();
    }

    public List<String> getNameList() {
        return nameList;
    }
}
