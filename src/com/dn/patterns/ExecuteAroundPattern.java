
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

    private Resource(){
        System.out.println("Resource created.");
    }
    
    private void open(){
        System.out.println("With in open");
    }
    public void operation1(){
        System.out.println("Within operation 1");
    }
    public void operation2(){
        System.out.println("Within operation 2");
    }
    private void close(){
        System.out.println("Resource closed.");
    }
    
    public static void use(Consumer<Resource> resourceConsumer){
        
        Resource resource = new Resource();
        try{
            resourceConsumer.accept(resource);
        }finally{
            resource.close();
        }
    }
}
