# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 기능 구현목록
* 사다리 게임 참여자
    * 참여자 이름은 한줄로 입력받고, 쉼표(,)로 구분한다.
    * 각 참여자 이름은 최대 5글자이다.
    * 예)
        * pobi, honux, crong, jk -> O
        * abcdef, paul, baul -> X
        * , , -> X 
* 사다리 게임판 구현
    * 사다리 높이를 입력 받는다. (숫자)
    * 사다리는 입력받은 높이만큼, 참여자 숫자만큼 생성된다.
        * 예를 들어 참여자가 4명, 높이가 5인경우, 4 * 5 사다리가 생성된다.
    * 각 사다리 세로 사이엔 이동할 수 있는 가로 라인이 들어갈 수 있다.
    * 사다리 타기가 정상적으로 동작하려면 가로 라인이 겹치지 않아야 한다. (연속해서 라인이 나올 수 없다.)
    * 참여자와 완성된 사다리, 사다리 실행 결과를 출력한다. 
* 사다리 실행 결과
    * 실행 결과 (각 사다리의 결과 값)을 입력 받고, 쉼표(,)로 구분한다.
    * 사다리 게임판을 출력한 후, 결과를 보고 싶은 사람을 입력받아서 결과를 출력한다.
        * '참여자 이름' 입력 -> 해당 참여자의 결과
        * 'all' 입력 -> 모든 참여자의 결과. 프로그램 종료
    
## 도메인 구현목록
* Members
    * Member 목록을 관리한다.
    * 입력 받은 문자열 값을 ',' 기준으로 분리하여 Member를 생성한다.
    * Member 목록의 크기를 MemberCount로 반환한다.
* Member
    * 입력 받은 문자열을 참여자의 이름으로 저장하여 관리한다.
* MemberCount
    * 입력 받은 참여자들의 숫자를 관리한다.
* LadderGame
    * 사다리 게임을 관리한다.
    * Members와 Ladder를 가진다.
    * 게임을 실행하여 LadderGameResult를 반환한다.
* Ladder
    * LadderLines와 LadderPoleResults를 관리한다.
    * LadderLines의 실행 결과를 리턴한다.
* LadderLines
    * LadderHeight 만큼의 가로 줄(LadderLine)을 관리한다.
    * LadderPole을 입력 받아 해당하는 게임 결과인 LadderGameReword를 리턴한다. 
* LadderBridge
    * 사다리 pole 사이의 가로 줄 유무를 관리한다.
* LadderHeight
    * 입력 받은 Ladder의 높이를 관리한다.
* LadderLine
    * (MemberCount - 1) 만큼의 LadderBridge를 관리한다.
    * 입력받은 LadderPole을 LadderBridge에 맞게 진행하여 새로운 LadderPole으로 리턴한다.
* LadderPole
    * 사다리의 pole (세로 라인) 을 관리한다. 
* LadderGameRewords
    * LadderPoleResults를 관리한다.
    * 입력 받은 문자열 값을 ',' 기준으로 분리하여 LadderGameReword 목록을 생성한다.
* LadderGameReword
    * 입력 받은 문자열을 사다리 기둥의 결과로 저장하여 관리한다.    
* LadderGameResult
    * 게임 결과를 관리한다.
    * 게임 결과는 Member와 LadderPoleResult를 매칭하여 관리한다.