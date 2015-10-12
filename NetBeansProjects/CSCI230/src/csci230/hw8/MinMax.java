
package csci230.hw8;
/**
 * A simple object to store two values to be returned by a function.
 * Admission of poor practice: minimally documented
 * @author Liz Healy
 */
public class MinMax<AnyType extends Comparable<? super AnyType>> {
    AnyType  minimum;
    AnyType  maximum;
    
    // Constructor for convenience
    public MinMax (AnyType minVal, AnyType maxVal){
        minimum = minVal;
        maximum = maxVal;
    }
    
    // Constructor 
    public MinMax(){
        // no values yet to assign
    }
    
    public AnyType getMin(){
        return minimum;
    }
    public AnyType getMax(){
        return maximum;
    }
               
    public void setMin(AnyType val){
        minimum = val;
    }
    public void setMax(AnyType val){
        maximum = val;
    }
    
    // So your can see display contents         
    public String toString(){
        return "minimum="+minimum+", maximum="+maximum+"\n";
    }
    
}
