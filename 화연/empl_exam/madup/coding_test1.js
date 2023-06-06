/**
 * 1번 역부터 n 번 역 사이를 운행하는 기차들이 있습니다. 
 * 모든 기차는 각각 수용 인원이 정해져 있고, s 번 역부터, s + 1 번역, s + 2 번역, ... e 번 역까지 운행합니다. 
 * 모든 기차가 한 번만 운행한다고 했을 때, 당신은 최대한 많은 손님이 기차를 이용할 수 있도록 예약을 받으려 합니다.

 * 손님들의 예약 요청에는 승차하는 역 번호와, 하차하는 역 번호가 있습니다. 
 * 손님의 요청처럼 곧바로 이동할 수 있는 기차가 없거나, 이용하려는 기차의 수용 인원을 초과할 경우 환승 시스템을 이용할 수 있습니다. 
 * 모든 기차는 같은 역에 방문하는 시간이 같다고 가정합니다. 
 * 즉, 동일한 역을 지나는 기차끼리 환승이 가능합니다. 
 * 환승하는 횟수의 제한은 없습니다.

 * 기차의 최대 수용 인원수를 넘지 않도록, 최대한 많은 손님의 예약을 받으려 합니다.
 * 
 * 기차역의 개수를 의미하는 정수 n , 기차의 정보를 담은 2차원 정수 배열 trains, 기차 예매 정보를 담은 2차원 정수 배열 bookings가 매개변수로 주어집니다. 
 * 최대 예약 수를 return 하도록 solution 함수를 완성해 주세요.
 * 
 * [제한사항]
 * 3 ≤ n ≤ 500
 * 1 ≤ trains 의 길이 ≤ 10,000
 * trains 의 원소는 [ s , e , k ] 형태입니다. s 번 역부터 e 번 역까지 운행하고, 최대 수용 인원이 k 인 기차를 의미합니다.       
 *    1 ≤ s < e ≤ n
 *    1 ≤ k ≤ 1000
 * 1 ≤ bookings 의 길이 ≤ 50,000
 * bookings의 원소는 [ a , b ] 형태입니다. a 번 역에서 승차하여 b 번 역에서 하차하는 예약을 의미합니다.       
 *    1 ≤ a < b ≤ n
 */

function solution(n, trains, bookings) {
  let answer = 0;
  const offTrains = [...bookings].sort(([a, b], [c, d]) => b - d || c - a);
  
  for(let i = 0; i < offTrains.length; i++) {
    if(i === 0) {
      
      answer++;
      continue;
    }

  }
  return answer;
}



function isAnswer() {
  const n1 = 5;
  const n2 = 7;

  const trains1 = [[1, 5, 2], [2, 3, 1]];
  const trains2 = [[1, 3, 3], [4, 7, 3]];

  const bookings1 = [[1, 5], [1, 3], [2, 5], [2, 4], [2, 4], [3, 5], [4, 5]];
  const bookings2 = [[1, 3], [2, 5], [3, 7], [4, 7], [5, 6], [6, 7], [5, 7]];

  const result1 = 4;
  const result2 = 5;

  if(solution(n1, trains1, bookings1) === result1 && solution(n2, trains2, bookings2) === result2) {
    console.log("정답입니다!");
  } else {
    console.log("흑흑! 틀렸어요!!");
  }
}