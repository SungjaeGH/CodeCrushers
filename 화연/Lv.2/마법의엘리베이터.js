/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/148653
 * @author HwaYeon
 * @param {number} storey 
 * @returns 
 */
function solution(storey) {
  let answer = Number.MAX_SAFE_INTEGER;

  const dfs = (num, counter) => {
    if(counter >= answer) return;
    
    if(num === 0) {
      answer = counter;
    } else {
      let res = num % 10;
      dfs(Math.floor(num / 10), counter + res);
      dfs(Math.floor(num / 10) + 1, counter + 10 - res);
    }
  }

  dfs(storey, 0);
  return answer;
}




/**
 * @param {number} storey 
 * @returns 
 */
function solution(storey) {
  if (storey < 5) return storey;
  const r = storey % 10;
  const m = (storey - r) / 10;
  return Math.min(r + solution(m), 10 - r + solution(m + 1));
}