# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## Step1. 자바8 스트림, 람다, 옵셔널
### 실습1 - 람다
- [X] 익명 클래스를 람다로 전환하기
- [X] 람다를 활용해서 중복 제거하기
    - [X] 변경되는 부분을 인터페이스로 추출한다.
    - [X] 익명 클래스로 구현해본다.
    - [X] lambda로 바꿔본다.

### 실습2 - Stream
- [X] StreamStudy의 sumOverThreeAndDouble을 구현한다.
    - [X] 3을 넘는 숫자만 골라내도록 구현한다. (filter)
    - [X] 골라낸 숫자에 모두 2를 곱하도록 구현한다. (map)
    - [X] 골라낸 숫자에 2가 곱해진 값을 모두 더한다. (reduce)
- [X] printLongestWordTop100을 구현한다.
    - [X] 단어의 길이가 12자를 초과하는 단어만 추출한다.
    - [X] 긴 순서로 100개만 추려낸다.
    - [X] 추려낸 단어는 중복 없이 100개 단어여야 한다.
    - [X] 추려낸 단어를 모두 소문자로 바꾼 뒤 출력한다.

### 실습3 - Optional
- [X] ageIsInRange2를 optional, stream을 사용해서 UserTest를 모두 통과하도록 구현한다.
- [X] getUser 메서드를 stream, optional을 활용해 구현한다.
- [X] ExpressionTest가 통과하도록 stream을 이용해서 Expression의 of 메서드를 구현한다. 

### 피드백 반영
- [X] Lambda를 메서드당 들여쓰기 한 번으로 줄이도록 개선한다.
- [X] lambda limit 메서드를 통해 리스트 자르기를 대체한다.
- [X] 에러 발생 시 좀 더 정확한 메시지를 던지도록 개선한다.
- [X] getter 대신 객체에게 메시지를 던질 수 있도록 개선한다.

## Step2. 사다리(생성)
- [X] Line 객체
    - 사다리 게임의 한 단계를 책임진다.
    - 내부적으로 lineFactory 컬렉션을 관리한다.
    - 사다리를 놓을 수 있는 곳과 없는 곳에 boolean 값을 배치한다.
    - [X] 참여하는 인원수를 입력받아서 객체를 생성할 수 있다.
    - [X] 참여하는 인원수는 무조건 1 이상이어야 한다.
    - [X] 첫번째 칸에는 무조건 다리를 놓을 수 없다.
    - [X] 바로 전 칸에 다리가 없다면, 현재 칸에는 다리를 놓을 수 있다.
    - [X] 바로 전 칸에 다리를 놓았다면, 현재 칸에는 다리를 놓을 수 없다.(연속해서 다리를 놓을 수 없다.)
- [X] Points 일급 컬렉션
    - Points 컬렉션 관리 자체에 대한 책임이 점점 커지는 것으로 생각되어 일급 컬렉션으로 분리
    - 사실상 Line이 Point 일급 컬렉션 역할을 아닌가 생각했는데, 그렇게는 구조가 잘 안나오는 것 같아서 분리했습니다.
    - [X] 객체 생성시 첫번째 값이 false인 콜렉션을 속성으로 가짐
    - [X] add 메서드를 통해 내부 컬렉션에 값을 추가할 수 있음
        - [X] 추가 시 내부 컬렉션의 가장 마지막 상태가 false면 true 추가
        - [X] 추가 시 내부 컬렉션의 가장 마지막 상태가 true면 false 추가
- [X] Ladder 객체
    - Line 콜렉션을 속성으로 갖는다.
    - [X] Ladder의 최대 높이와 인원수를 입력받아서 객체를 생성 할 수 있다.
    - [X] Ladder의 최소 높이는 1 이상이어야 한다.
- [X] PlayerName 객체
    - [X] value를 속성으로 갖는다.
    - [X] 1 ~ 5글자 사이의 value로 객체를 생성할 수 있다.
    - [X] null이나 빈 문자열로 객체를 생성할 수 없다.
- [X] PlayerNames 객체
    - PlayerName을 관리하는 일급 컬렉션이다.
    - [X] 쉼표로 구분된 문자열을 입력 받아서 객체를 생성할 수 있다.
    - [X] null이나 빈 문자열로 객체를 생성할 수 없다.
    - [X] 갖고 있는 PlayerName 중 가장 긴 이름의 길이를 알 수 있다.
- [X] InputView 객체
    - 게임에 참여할 사람 명단, 최대 사다리 높이를 입력받는 객체
    - [X] 사다리 게임에 참여할 사람 목록, 최대 사다리 높이를 입력받아서 객체를 생성할 수 있다.
    - [X] 객체 생성 시 System Scanner를 통해 값을 입력받을 수 있다.
    - [X] 최대 사다리 높이가 0 이하인 경우 예외 발생하도록 validation
- [X] OutputView 객체
    - InputView의 값을 기반으로 생성된 Ladder를 출력할 수 있다.
    - [X] PlayerNames, Ladder 객체를 주입받아서 객체를 생성할 수 있다.
    - [X] 제일 긴 이름 길이, Line 객체를 받아서 사다리 한 줄을 출력할 수 있다.
    - [X] Ladder의 모든 Line을 출력할 수 있다.
    - [X] 출력된 Ladder의 폭에 맞게 Ladder 위에 참여자 명단을 출력할 수 있다.
- [X] UiController 객체
    - InputView와 OutputView를 잘 조율해서 결과를 출력한다.
- [X] PointAddStrategy 인터페이스
    - 고정적으로 사다리가 생성되는 현상을 방지하기 위해, 정책에 따라 사다리 point 추가가 변화하도록 구현
    - [X] 다리를 놓을 수 있는 위치에서 진짜로 놓을 것이지 확정하는 인터페이스 구현

### 1차 리뷰 반영
- [X] 가독성을 위한 개행(Ladder)
- [X] 메서드의 시작은 동사로 (모든 validation 메서드들)
- [X] 중복되는 의미의 클래스 속성명 수정 (PlayerName)
- [X] 고정적인 의미의 문자열 상수화(PlayerNames, InputView, OutputView)
- [X] 인터페이스 메서드명을 좀 더 구체적으로 변경(PointAddStrategy)
- [X] Line과 Points로 굳이 일급 컬렉션을 나눠야 하는지 고민해본다
    - [X] 나누지 않게 될 경우 add 연산이 아니라 아예 정적 팩토리 메서드로 새로 만드는 방법을 고려해본다.
    - Line의 생성 관련 복잡성을 다루기 위해서는 Factory 객체가 더 맞다고 판단되어 Factory 패턴을 사용하도록 리팩토링 진행
- [X] InputView를 초기화하는 과정을 세분화해본다
- [X] draw 메서드 시리즈의 더 적합한 이름을 고민해본다(OutputView)
- [X] 테스트 코드 중복 해소(OutputViewTests)

### 2차 리뷰 반영
- [ ] OutputView 세분화 고려 (사다리와 관련된 부분만 따로 뽑아내기)
- [X] Line의 Boolean까지 포장 해보기
- [X] 만들어 둔 상수 사용하기 (LineFactory)
- [X] 지나치게 구체적인 메서드명 이름 다시 고려하기
- [X] 상수와 인스턴스 변수 간 개행 추가
- [X] 메서드는 동사로 시작하기(OutputView)

## Step3. 사다리(게임 실행)
- 사다리 게임 수행 결과를 보여줄 수 있어야 한다.
- 참가자의 이름을 입력 받아서 개인의 사다리 게임 수행 결과를 확인할 수 있어야 한다.
- all을 입력 받아서 참여 인원 모두의 사다리 게임 수행 결과를 확인할 수 있어야 한다.
    - all을 입력받기 전까지 계속해서 개별 사용자 결과 확인을 진행할 수 있다.
    - all로 결과를 확인하면 확인 절차가 종료된다.
- 실행 결과를 입력받을 수 있어야 한다.
    - 실행 결과의 수량은 참여자의 수와 같아야 한다.

### Todo List
- [X] Player(구 PlayerName) 객체
    - [X] 이름 외에 현재 위치를 관리하도록 리팩토링
    - [X] 오른쪽 이동 시 현재 위치 값 +1
    - [X] 왼쪽 이동 시 현재 위치 값 -1
    - [X] 현재 위치는 0보다 작지 않은지 검증한다.
        - Location에 대한 검증이 Player 객체에서 수행하기 쉽지 않음 (특히 최대값)
        - 아예 별도 객체로 분리해서 관리
- [X] HorizontalLocation 객체
    - 사다리 게임에서 Player의 현재 가로 위치를 나타내는 객체
    - [X] 0 ~ 사다리 게임 참여 인원 사이의 값을 가짐
    - [X] 유효 범위 내에서 증가 연산이 가능함.
    - [X] 유효 범위 내에서 감소 연산이 가능함.
- [X] Players(구 PlayerNames) 일급 컬렉션
    - [X] Player 객체를 관리하는 일급 컬렉션으로 리팩토링
    - [X] 내부의 Player를 움직일 때 locaiton이 현재 참여자 전체의 수보다 크지 못하게 검증한다.
        - Location 검증은 모두 HorizontalLocation 객체에서 알아서 처리
- [X] Ladder
    - [X] Player 객체를 입력받아서 현재 상태를 기준으로 사다리 게임을 진행할 수 있음
        - [X] 각 Line에 맞게 게임 진행
        - [X] Ladder의 모든 라인을 진행해야 함
        - Ladder 생성 규칙에 의해 두 위치가 모두 true인 경우는 존재하지 않는다.
    - [X] Players 객체를 전달 받아서 모든 참가자들의 사다리 게임을 진행할 수 있다.
- [X] Line
    - [X] Player 객체를 입력 받아서 현재 Point가 true면 왼쪽 이동 실행 (폐기)
    - [X] Player 객체를 입력 받아서 다음 Point가 true면 오른쪽 이동 실행 (폐기)
        - [X] 끝자리 여부 확인 필요 (끝자리인 경우 다음 Point 확인 안함) (폐기)
    - Player를 Line에 주입하는 형태로 구현 시 Player의 getter를 걷어낼 방안이 없음(이렇게 해도 getter 걷어내기 쉽지 않음..)
    - Line에 확인하고 싶은 index를 전달하면 알맞는 정책 객체를 반환하도록 구현
    - [X] 인자로 전달된 index의 Point가 true면 왼쪽 이동 정책 반환
    - [X] 인자로 전달된 index의 옆 Point가 true면 오른쪽 이동 정책 반환
        - [X] 인자로 전달된 index가 Line index의 마지막이고, 현재 index가 true면 왼쪽 이동 정책 반환
        - [X] 인자로 전달된 index가 Line index의 마지막이고, 현재 index가 false면 이동없음 정책 반환
    - [X] 위 두가지 경우에 속하지 않는다면 이동없음 정책 반환
- [X] MoveStrategy
    - currentPoint, nextPoint를 상태로 가짐
    - (true, true) => 존재하지 않음 (사다리 게임 정책상 없음)
    - (true, false) => 왼쪽으로 이동
    - (false, true) => 오른쪽으로 이동
    - (false, false) => 이동하지 않음
- [X] Reward
    - [X] 상품명과 상품의 당첨 Player를 속성으로 갖는다.
    - [X] 상품명과 Player 객체를 입력받아서 객체를 생성할 수 있다.
    - [X] 상품명이 null이나 비었을 경우 예외 발생
    - [X] 사다리 배치를 위해 상품명은 5글자를 넘을 수 없다.
- [X] Rewards
    - Reward 일급 컬렉션
    - [X] 정적 팩토리 메서드로 Players, RewardValue을 입력 받아서 객체를 생성할 수 있다.
    - [X] RewardValue를 String 컬렉션으로 파싱할 수 있다.
    - [X] RewardValue를 String 컬렉션으로 파싱한 크기와 Players의 크기가 다르다면 예외가 발생한다.
    - [X] PriceValue가 null이거나 비었을 경우 예외 발생
    - 객체 책임 수정: 단순히 사다리 게임의 상품명만을 관리하도록 수정 (입력되는 값에 대해서만 관리)
- [X] GameResult
    - 어떤 유저가 어떤 상품을 갖는지에 대한 정보는 따로 관리가 필요함
    - Rewards에서 어떤 유저가 어떤 상품을 갖고 있는지에 대한 책임을 따로 관리
    - [X] Player와 Reward 객체를 전달 받아서 객체 생성 가능
- [X] GameResults
    - GameResult 일급컬렉션
    - [X] Players, Rewards를 전달 받아서 일급 컬렉션 생성 가능
    - [X] Players, Rewards 수가 다른 경우 예외 발생
    - [X] Player 이름으로 결과를 찾을 수 있음
- [ ] LadderGameService
    - 객체 간의 실행 순서를 지정함
    - GameResult는 반드시 게임이 실행 된 후에 만들어져야 하기 때문에 이를 서비스 레이어에서 제어
    
### 1차 리뷰 Todo List
- [X] 값 비교를 위한 getter 없애고 객체 간 비교로 바꾸기
- [X] HorizontalLocation의 속성명 구체화시키기, 속성명 의미에 맞게 변경하기
- [X] Ladder 내 패키지에서만 사용하는 메서드 접근 제한자 용도에 맞게 변경하기
- [X] Line 내 패키지에서만 사용하는 메서드 접근 제한자 용도에 맞게 변경하기
- [X] Player의 move 메서드 내부의 이름 통일성 높이기
- [X] Players 객체에서 사용자 입력값을 파싱하는 역할을 담당해야 될 지 고민하기
- [X] GameResultInputView 내부에 필요한 값 상수화 시키기
- [X] GameResultInputView에서 메서드화를 통해 depth 줄이기
- [X] 테스트 시 객체 간 비교를 활용하는 방안으로 개선하기
- [X] LineTest, PalyerTest에서 ParameterizedTest를 활용해서 중복 제거하기
- [X] HorizontalMoveStrategy 필터링 기능의 대상 캐싱하기
- [X] Player의 Location 값을 알아내는 getter 걷어내기 (메서드 역할을 다시 생각해보면서 객체간 책임을 설계할 것)
- [X] UiController의 메서드화를 통해 적당한 책임 분리하기
- [X] UiController에서 Scanner 꼭 여러개 사용해야 되는지 다시 확인
- [ ] Point의 boolean 값들을 상수화 시켜서 관리하기

### 2차 리뷰 Todo List
- [X] HorizontalMoveStrategy에서 각 객체별 Player 움직임에 대해 명시하도록 변경
- [X] Line 객체 메서드의 이름을 책임에 맞도록 변경
- [X] LadderHeightInputView의 상수 가독성 높이기
- [X] UIController의 Scanner 중복 해결하기
- [X] LineTests 테스트 좀 더 간결하기 바꾸기
- [X] LadderGameService 객체에 대해 다시 고려해보기
- [X] Ladder 내 게임 진행 메서드 개선하기
- [X] Domain 패키지를 역할별로 세분화하기

## Step 4. 사다리 추가 리팩토링
- [ ] 힌트 참고해서 Line 객체 테스트 케이스 추가 및 리팩토링 진행
    - [X] LadderLine으로 이름 변경
    - [ ] Line 객체에서 직접 Point를 이동시키도록 개선 
- [ ] 힌트 참고해서 Point 객체 테스트 케이스 추가 및 리팩토링 진행
    - [X] Point 객체는 현재 index와 direction을 인자로 갖는다.
    - [X] 어느 방향으로 움직일지는 Point가 자체적으로 판단하고 움직인다.
        - [X] HorizontalMoveStrategy는 정책에 따라 움직일 수 있는 정수값을 갖는다.
            - [ ] 모든 리팩토링이 완료되면 Player를 움직이던 함수형 인터페이스를 제거한다.
    - [ ] 현재 Point를 기반으로 다음 Point를 계산해서 반환할 수 있다.
    - [ ] 첫번째 Point를 고정적으로 생성할 수 있다.
    - [ ] 마지막 Point를 고정적으로 생성할 수 있다.
    - [ ] 어느 방향으로 움직일지는 Direction과 HorizontalMoveStrategy를 결합해서 결정한다.
- [ ] 힌트 참고해서 Direction 객체 테스트 케이스 추가 및 리팩토링 진행
    - [X] 현재 위치와 오른쪽 위치가 모두 true인 방향 생성 시 예외 발생
    - [X] Direction이 현재 상태를 기반으로 다음 Direction을 생성할 수 있어야 함.
        - [ ] 현재는 PointAddStrategy 사용하지만, 리팩토링 완료 후에는 NextDirectionStrategy로 이름 변경
- [ ] LadderLineFactory
    - [ ] 변경된 Point 생성자에 맞게 생성 로직 변경
