package dreamHorse;
import java.util.Random;

public class DreamHorseTry1 {

	public static void main(String[] args) {
		int count;
		int numDH = 100000; //number of dream horse
		long sum = 0;
		Random r = new Random();
		int max = 0; //�ִ� Ʈ���� Ƚ��
		int numOfOne = 0; //��Ʈ�� ������ Ƚ��
		
		for (int i = 1; i <= numDH; i++) {
			int probability = 10;
			for (count = 1; ; count++) {
				if (r.nextInt(1000) < probability) { //����
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

//100��ȸ �õ���� ��Ʈ ���� Ƚ���� �� 1��ȸ <= ��Ʈ ���� Ȯ�� 1����