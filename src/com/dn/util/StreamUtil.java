/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dn.util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author BPULI
 */
public class StreamUtil {
    
    public static <T,E,V> List<V> zip(List<T> inputArray1, List<E> inputArray2, Function<Integer, V> function){
        return IntStream.range(0, Math.min(inputArray1.size(), inputArray2.size()))
                        .mapToObj(i -> function.apply(i))
                        .collect(Collectors.toList());
    }
    
    public static void main(String arg[]){
        
        List<String> names = Arrays.asList("One", "Two", "Three", "Four", "Five","Six");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        zip(names, numbers, i -> new Tuple(names.get(i), numbers.get(i))).stream()
                                                                         .forEach(System.out :: println);
        List<String> names1 = Arrays.asList("One", "Two", "Three", "Four", "Five","Six");
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        zip(names1, numbers1, i -> new String[]{names1.get(i), String.valueOf(numbers1.get(i))}).stream()
                                                                         .forEach(pair -> System.out.println(pair[0] + "::" + pair[1]));
    }                                                                       
    
    static class Tuple<T,E>{
        
        private final T value1;
        private final E value2;
        public Tuple(T theValue1, E theValue2){
            this.value1 = theValue1;
            this.value2 = theValue2;
        }
        public T getValue1(){
            return this.value1;
        }
        public E getValue2(){
            return this.value2;
        }
        @Override
        public String toString(){
            return this.value1 + "--" + this.value2;
        }
    }
    
}
