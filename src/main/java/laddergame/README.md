#4단계 - 사다리(리팩토링)

## 리팩토링 목표
1. 도메인 객체를 직접 VIEW에서 접근해서 출력하는 부분을 개선해 본다. (만들어진 게임 출력부분은 어쩔수 없을듯..?)
    * 출력용 DTO 생성
    * 디미터의 법칙을 어기는 것 처럼 보이는 부분을 나름의 기준대로 정리
2. TestFixture 클래스를 사용해서 테스트 코드에 쓰기위해서 생성자를 public으로 설정 했던 부분 없애기
3. do-while문 while문으로 교체


## Feature List
1. GameCriteria, Ladder를 멤버 변수로 갖는 LadderGame 도메인 객체 작성 (기존 main메소드의 클래스였던 LadderGame은 Main으로 명칭 변경)
2. LadderGame의 게임 결과를 담는 DTO인 GameResult 작성
3. OutputHere에서 GameCriteria와 Ladder를 직접 쓰던 부분을 LadderGame(만들어진 내용 출력 부분)과 GameResult(사다리 타기 당첨자 출력부분)을 사용하게 변경
4. 나머지 3단계 코드리뷰 반영 (TestFixture를 활용해서 Line 클래스 default 생성자 유지, do-while문 while문으로 변경)

