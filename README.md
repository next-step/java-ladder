# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 2단계 - 사다리(생성) 기능 목록
#### view
* [X] 참가자 이름 입력 
* [X] 참가자 이름 출력
* [X] 사다리 높이 입력
* [X] 사다리 출력 
    * [X] 가로라인 : (-)로 혹은 공백으로, 폭 넓게 출력 (참가자 이름 최대 5자 고려)
    * [X] 세로라인 : (|)로 참가자수만큼 출력

#### domain
* [X] 사다리 게임 참가자 생성 (Participant)
    * [X] 이름 쉼표(,)로 split
    * [X] 참가자 이름 5자 제한 
* [X] 사다리 생성 (Ladder - List<Line>)
    * [X] 전체 사다리 : 참가자 인원수 * 사다리 높이  
    * [X] 가로 라인 생성 - size : 참가자 인원수, 각 좌표값은 이동여부 (left/ right) 값을 가진다. 
    * 첫번째 참가자 - right : 랜덤 생성, left : 무조건 false
    * 마지막 참가자 - right : 무조건 false, left : 앞 참가자의 right값이 true이면 true
    * 그 외 참가자 - right : 앞 참가자의 right값이 true인 경우 false/false인 경우 랜덤 생성, left : 앞 참가자의 right값이 true인 경우 true
    
* ex) 참가자 5명, 사다리 4인 경우 (참가자별로 가지는 좌표의 방향값이 다르다.)
* A     B     C     D     E
* . <-> .     . <-> .     .   첫번째 라인 
* .     . <-> .     . <-> .   두번째 라인
* . <-> .     .     .     .   세번째 라인
* . <-> .     .     . <-> .   네번째 라인
* A의 첫번째 라인은 right = true(Random 생성), left = (첫번째 라인이므로 무조건) false
* B의 첫번째 라인은 right = (연속생성 불가하므로 무조건) false, left = (A의 right가 true이므로) true 
* C의 첫번째 라인은 right = true(B의 right가 false이므로 Random 생성), left = (B의 right가 false이므로) false 
* D의 첫번째 라인은 right = (연속생성 불가하므로 무조건) false, left = (C의 right가 true이므로) true
* E의 첫번째 라인은 right = (마지막 라인이므로 무조건) false, left = (D의 right가 false이므로) false 

## 3단계 - 사다리(게임 실행) 기능 목록
#### view
* [X] 실행 결과 입력 
* [X] 실행 결과 보고 싶은 대상 입력 
* [X] 실행 결과 출력 
    * [X] 사다리 하단에 순서대로 출력 
    * [X] 이름 입력 시, 한 사람 결과 출력 
    * [X] all 입력 시, 전체 결과 출력 


#### domain
* [X] 입력된 실행 결과에 따라 LadderResult 생성
    * [X] 실행 결과 쉼표(,)로 split
    * [X] 입력한 실행 결과 개수와 인원수 일치 여부 
* [X] 실행 결과 생성
    * [X] 전체 결과 생성 -> 참가자별 결과 정보 가지도록 생성
    * [X] 참가자 이름으로 결과 반환
