//package nextstep.ladder;
//
//import nextstep.ladder.domain.ladder.DirectionRandomPredicate;
//import nextstep.ladder.domain.ladder.Height;
//import nextstep.ladder.domain.ladder.Ladder;
//import nextstep.ladder.domain.ladder.LadderGenerator;
//import nextstep.ladder.utils.UserConverter;
//import nextstep.ladder.view.InputView;
////import nextstep.ladder.view.ResultView;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        String[] users = InputView.inputUserName();
//        int maxHeight = InputView.inputMaximumLadderHeight();
//
//        LadderGenerator ladderGenerator = new LadderGenerator(users.length, Height.of(maxHeight));
//        Ladder ladder = ladderGenerator.generate(new DirectionRandomPredicate());
//
////        ResultView.printResult(UserConverter.convertToString(users), ladder);
//    }
//}
