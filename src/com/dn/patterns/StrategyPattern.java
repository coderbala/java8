
package com.dn.patterns;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author BPULI
 */
public class StrategyPattern {

    public static int totalValues(List<Integer> values, Predicate<Integer> condition){
        
        return values.stream()
              .filter(condition)
              .reduce(0, Integer :: sum);
    }
    
    public static void main(String[] args){
        
        List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        
        System.out.println("Total of all elements: " + totalValues(values, e -> true));//total all values
        System.out.println("Total of even elements: " + totalValues(values, e-> e%2==0));
        System.out.println("Total of Odd elements: " + totalValues(values, e-> e%2!=0));
        System.out.println("Total of elements divisible by 3: " + totalValues(values, e-> e%3 ==0));
    }
    
}
