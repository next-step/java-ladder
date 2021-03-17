# 사다리 게임

## User
- userName은 5자이상 불가

## Users
- users는 문자열로 받음 
- , 가 기준점이되어 split

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
