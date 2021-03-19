# 사다리 게임

## User
- userName은 5자이상 불가

## Users
- users는 문자열로 받음 
- , 가 기준점이되어 split
- 유저기준으로 move

## Root
- 사다리의 옆라인으로 가는 것
- RootMakeStrategy로 옆으로 이동 할지에대한 여부를 주입받아 존재여부 체크

## Line 
- 사람의 수만큼 Root를 만듬
- 먼저, random하게 라인당 Root를 만듬
- 곂치면 안되니, 먼저 random하게 만든거에서 이전꺼를 확인후 만약 이전 Root가 true라면 현재꺼는 false
- currying을 이용하여 function 분리

## Ladder
- lines를 가지게됨
- User 정보를 가지고 있음
- 다음단계를 고려하여 결과값을 위해 user정보는 소유

## Position
- 현재 위치 표시
- 오른쪽으로 이동할지 왼쪽으로 이동할지, 이동하지 않을지 move하는 객체

## Prize
- 상품 결과를 가져가는 object
- 상풍 갯수와 참가자 인원이 맞지않으면 exception

## ScoreBoard
- 최종 결과 값을 가져가는 object
- 각 인원들 key 값을 가져가는 result map field 소유
- all key -> 전체 인원 value



