package com.dn.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindMinMax {
	
	public static int findMinimun(List<Integer> input){
	
		return input.stream()
					.collect(Collectors.reducing(Math :: min )).orElse(Integer.MAX_VALUE);
	}

	public static int findMaximum(List<Integer> input){
		
		return input.stream()
					.collect(Collectors.reducing(Math :: max)).orElse(Integer.MIN_VALUE);
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(findMaximum(Arrays.asList(10,9,8,7,44,55,66,2000,10,3,4)));
		System.out.println(findMinimun(Arrays.asList(10,9,8,7,44,55,66,2000,10,3,4)));
	}

}
