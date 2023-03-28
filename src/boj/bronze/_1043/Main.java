package boj.bronze._1043;

import java.io.*;
import java.util.*;

public class Main {
	
	static boolean[] arrayTrueMans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
//		인원 수, 파티 수
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
//		진실을 알고 있는 사람들
		arrayTrueMans = new boolean[51];
		st = new StringTokenizer(br.readLine());
		int number_true_mans = Integer.parseInt(st.nextToken());
		for (int i=0 ; i<number_true_mans; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			arrayTrueMans[tmp] = true;
		}
//		System.out.println(Arrays.toString(arrayTrueMans));
		
//		파티
		List<List<Integer>> party = new ArrayList<>();
		for (int i=0 ; i < M ; i ++) {
			List<Integer> current_pt = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int number_party_mans = Integer.parseInt(st.nextToken());
			for (int j=0 ;  j <number_party_mans; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				current_pt.add(tmp);
			}
			party.add(current_pt);
		}
//		System.out.println(party);
		
//		1. 파티 돌면서 확인하기
		int prev_results = M;
		int results = M;
		
		while (true) {
			for (int i=0; i < M; i++) {
				List<Integer> participants = party.get(i);
				for (int j=0; j < participants.size(); j++) {
					if (arrayTrueMans[participants.get(j)]) {
						results -= 1;
						updateTrueMans(participants);
						break;
					}
				}
			}
			
			if (prev_results == results) {
				break;
			} else {
				prev_results = results;
				results = M;
			}
		}
		
		System.out.println(results);
	}
	
	public static void updateTrueMans(List<Integer> participants) {
		for (int num: participants) {
			arrayTrueMans[num] = true;
		}
	}

}
