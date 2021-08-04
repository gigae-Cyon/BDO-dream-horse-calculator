# BDO-dream-horse-calculator
This is a calculator to know average trial number of 'dream horse' in online game, BDO(black desert online) experimentally.<br/>
Initial probability is 1%. Every fail in the reinforce, the probability increases 0.2%p.<br/>

온라인 게임 검은사막의 평균 환상마 트라이 횟수를 실험적으로 계산하기 위한 프로그램입니다.<br/>
초기 성공확률은 1%이고, 실패할 때마다 성공확률은 0.2%p씩 올라갑니다.<br/>

In src directory, there are 2 java files. DreamHorseTry1.java is more memory saving than DreamHorseTry.java.<br/>
src디렉토리의 두 개의 java파일 중 DreamHorseTry1.java가 더 메모리 효율적인 버전입니다.<br/>

21.05.03 8티 말도 없을 때 환트 준비하며 만들었던 코드

### DreamHorseTry1.java
```java
package dreamHorse;
import java.util.Random;

public class DreamHorseTry1 {

	public static void main(String[] args) {
		int count;
		int numDH = 100000; //number of dream horse
		long sum = 0;
		Random r = new Random();
		int max = 0; //최대 트라이 횟수
		int numOfOne = 0; //원트로 성공한 횟수
		
		for (int i = 1; i <= numDH; i++) {
			int probability = 10;
			for (count = 1; ; count++) {
				if (r.nextInt(1000) < probability) { //성공
					break;
				}
				else { probability += 2; }
			}
			sum += count;
			if (count > max) max = count;
			if (count == 1) numOfOne++;
			if (i%20 == 0) System.out.printf("%3d\n", count);
			else System.out.printf("%3d, ", count);
		}
		double average = (double)sum / (double)numDH;
		System.out.println();
		System.out.println("average number of [" + numDH + "]try is " + average);
		System.out.println("maximum try : " + max);
		System.out.println("number of one try : " + numOfOne);
	}
}

//100만회 시도결과 원트 성공 횟수가 약 1만회 <= 원트 성공 확률 1프로
```


### DreamHorseTry.java
```java
package dreamHorse;
import java.util.Random;

public class DreamHorseTry {

	public static void main(String[] args) {
		int count;
		int[] countArr = new int[200];
		Random r = new Random();
		
		for (int i = 0; i < countArr.length; i++) {
//			r.setSeed(System.currentTimeMillis());
			int probability = 10;
			for (count = 1; ; count++) {
				if (r.nextInt(1000) < probability) { //성공
					break;
				}
				else { probability += 2; }
			}
			countArr[i] = count;
			System.out.println(countArr[i]);
		}
		
		int sum = 0;
		double average;
		for (int i = 0; i < countArr.length; i++) {
			sum += countArr[i];
		}
		average = (double)sum / (double)countArr.length;
		System.out.println(average);
	}
}
```
