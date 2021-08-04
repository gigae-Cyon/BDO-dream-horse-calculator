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