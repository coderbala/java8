
package com.dn.patterns;

import java.util.function.Consumer;

/**
 *
 * @author BPULI
 */
public class ExecuteAroundPattern {
    
    public static void main(String[] args){
        Resource.use(
                (resourceConsumer)->{
                        resourceConsumer.operation1();
                        resourceConsumer.operation2();
                } 
        );
    }
}

class Resource{
    
    private static final Consumer<String> printMe = System.out :: println;
    
    private Resource(){
        printMe.accept("Resource created.");
    }
    
    private void open(){
        printMe.accept("With in open");
    }
    public void operation1(){
        printMe.accept("Within operation 1");
    }
    public void operation2(){
        printMe.accept("Within operation 2");
    }
    private void close(){
        printMe.accept("Resource closed.");
    }
    
    public static void use(Consumer<Resource> resourceConsumer){
        
        Resource resource = new Resource();
        try{
            resource.open();
            resourceConsumer.accept(resource);
        }finally{
            resource.close();
        }
    }
}
