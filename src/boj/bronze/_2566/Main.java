package boj.bronze._2566;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;


public class Main {
	public static void main(String[] args) throws IOException {
		// 파일 경로는 src부터 적는다.. (킹받아)
		System.setIn(new FileInputStream("src/boj/bronze/_2566/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] array = new int[9][9];
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for (int i = 0; i < array.length; i++) {
//			System.out.println(Arrays.toString(array[i]));			
//		}
		
		int max = -1;
		int[] max_position = new int[2];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (array[i][j] > max) {
					max = array[i][j];
					max_position[0] = i+1;
					max_position[1] = j+1;
				}
			}
			
		}
		
		System.out.println(max);
		System.out.println(max_position[0] + " " + max_position[1]);
				
	}

}
