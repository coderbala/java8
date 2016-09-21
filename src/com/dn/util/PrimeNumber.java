
package com.dn.util;

import java.util.stream.IntStream;

/**
 *
 * @author BPULI
 */
public class PrimeNumber {
    
    public static boolean isPrime(int number){
        
        return number > 1 && IntStream.range(2, number)
                                      .noneMatch( i -> number%i ==0);
    }
    
    public static void main(String[] args){
        System.out.println(isPrime(10));
        System.out.println(isPrime(3));
        System.out.println(isPrime(5));
    }
    
}
