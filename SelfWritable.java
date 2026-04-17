
public interface SelfWritable
{
    /**
     * This method prints writes a file that contains the source code of
     * the class that implements it. 
     * The file  should be named <ClassName>.java or avaj.<emaNssalC> depending on 
     * the parameter passed. 
     * If the parameter is "false" then the source code should be identical to the
     * source code of the Class that implements this method.
     * If the parameter is "true" then the source code will be mirrored (upside down).
     * @param mirrored A parameter that indicates whether we want the file to contain
     * the source code, or the mirrored source code of the class that implements this method.
     */
    public void writeSelf(boolean mirrored);
}
