package device;

import domain.NameTagGroup;
import domain.ResultTagGroup;

public class OutputDevice {

    public static void ladderResult() {
        System.out.println("사다리 결과");
    }

    public static void runResult() {
        System.out.println("실행 결과");
    }

    public static void ladderView(NameTagGroup nameTagGroup) {
        nameTagGroup.viewLadder().forEach(System.out::println);
    }

    public static void viewName(String name) {
        System.out.println(name);
    }

    public static void allResultView(NameTagGroup nameTagGroup, ResultTagGroup resultTagGroup) {
        for (int i = 0; i < nameTagGroup.size(); i++) {
            int position = nameTagGroup.getFinalPosition(i);
            System.out.println(nameTagGroup.getName(i) + " : " + resultTagGroup.getName(position));
        }
    }

    public static void viewInputValues(NameTagGroup nameTagGroup) {
        nameTagGroup.getNames().forEach(System.out::print);
        System.out.println();
    }

    public static void viewResultValues(ResultTagGroup resultTagGroup) {
        resultTagGroup.getNames().forEach(System.out::print);
        System.out.println();
    }

    public static void viewResultOneAndAll(NameTagGroup nameTagGroup, ResultTagGroup resultTagGroup) {
        while (true) {
            String name = InputDevice.knowResult();
            OutputDevice.runResult();
            if (name.equals("all")) {
                OutputDevice.allResultView(nameTagGroup, resultTagGroup);
                break;
            }
            OutputDevice.viewName(
                    resultTagGroup.getName(
                            nameTagGroup.getFinalPosition(
                                    nameTagGroup.indexOf(name))));
        }
    }

}
