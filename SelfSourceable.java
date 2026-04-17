
public interface SelfSourceable 
{
    /**
     * This method should read the source code of the 
     * class that implements it, and return it as a String.
     * @return Returns a String object that contains the 
     * entire source code as it was read by the source code file
     * of the class that implements the method.
     */
    public String getSourceCode();
}
