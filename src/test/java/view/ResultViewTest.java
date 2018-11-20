package view;

import domain.NameTag;
import org.junit.Test;
import utils.StringUtils;

import java.util.List;

public class ResultViewTest {


    @Test
    public void printNames() {

        String names = "test1,test2,test3,test4";
        List<NameTag> nameTags = StringUtils.makeNameTag(names);
//        ResultView.printNames(nameTags);
    }

}