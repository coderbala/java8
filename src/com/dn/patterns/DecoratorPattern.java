package com.dn.patterns;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 *
 * @author BPULI
 */
public class DecoratorPattern {

    private static final BiConsumer<String, String> printMe = (inputStr, outputStr) -> System.out.println(String.format("with input: %s : %s", inputStr, outputStr));

    public static void main(String[] args) {

        Function<String, String> upperCase = e -> e.toUpperCase();
        Function<String, String> hideLetterJ = e -> e.replaceAll("[Jj]", "X");

        final Transformer transformer = new Transformer();
        String input = "This is simple decorators with java 8";
        String output = transformer.transform(input);
        printMe.accept(input, output);
        
        transformer.setFunctions(upperCase, hideLetterJ);
        output = transformer.transform(input);
        printMe.accept(input, output);
    }
}

class Transformer {

    private Function<String, String> function;

    public Transformer() {
        this.setFunctions();
    }

    public void setFunctions(Function<String, String>... functions) {
        this.function = Arrays.asList(functions)
                              .stream()
                              .reduce((filter, next) -> filter.andThen(next))
                              .orElse(Function.identity());    
    }

    public String transform(String input) {
        String output = this.function.apply(input);
        return output;
    }
}
