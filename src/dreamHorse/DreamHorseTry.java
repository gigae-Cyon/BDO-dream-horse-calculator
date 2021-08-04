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
				if (r.nextInt(1000) < probability) { //¼º°ø
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