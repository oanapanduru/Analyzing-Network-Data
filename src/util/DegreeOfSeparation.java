package util;

import java.util.Map;

public class DegreeOfSeparation {

	public static int degreeOfSeparation(Map<Integer, Integer> distanceFrequencies) {
		int degreeOfSeparation = 0;
		int max = 0;
		//searching for the max value of the frequencies
		for(Integer i: distanceFrequencies.keySet()) {
			if(distanceFrequencies.get(i)>max) {
				max=distanceFrequencies.get(i);
			}
		}
		for(Integer key: distanceFrequencies.keySet()) {
			if( distanceFrequencies.get(key)== max) {
				degreeOfSeparation=key;
			}
		}
		System.out.print("Based on the input data the most common degree of separation between any nodes is of " );
		return degreeOfSeparation;
	}
}
