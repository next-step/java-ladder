# 사다리 게임
## 기능 요구사항
### Step2
* 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
* 사람 이름은 쉼표(,)를 기준으로 구분한다.
* 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
* 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
    *  |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
### Step3
* 사다리 실행 결과를 출력해야 한다.
* 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.

## 프로그래밍 요구사항
### Step2
* 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
* 규칙 6: 모든 엔티티를 작게 유지한다.
### Step3
* 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
* 규칙 6: 모든 엔티티를 작게 유지한다.
* 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.

## 객체 설명
* client
    * LadderGameClient - 클라이언트 객체
* controller
    * PlayLadderGame - 컨트롤러 객체
* domain
    * Ladder - 사다리 관리객체
        * 라인 생성
    * LadderDirection - 사다리 방향 관리 객체
    * LadderDirectionNext - 다음 사다리 방향 생성 객체
    * LadderGame - 사다리게임 관리 객체
    * LadderLine - 사다리의 한 라인 생성 및 관리
        * 데이터 체크
    * LadderPoint - 사다리 point 관리객체
    * LadderWinning - 당첨관리 객체
    * LadderWinnings - LadderWinning의 일급컬렉션 객체
    * Person - 참여자 관리객체
    * Persons - 참여자의 일급컬렉션
    * LadderPrint - 출력 관리 객체
    * MappingWinningDTO - 이동한 데이터와 매핑을 담는 객체
  

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)