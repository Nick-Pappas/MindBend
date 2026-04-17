///////////////////////////////////////////////////////////////////////////////
// CS302 Summer 2013 - Project 5
// Author: Nick Pappas
//
// (You guys put your wisc.edu email here.)
// (Credits here, if you got help from anyone but me)
///////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A self-replicating Quine class that can print its own source code,
 * read its own source code file, and write itself to a new file.
 * Crucially, it also features QuineMirrorable functionality, allowing it to
 * write its source code backwards (both reversed lines and reversed filename).
 */
public class MindBend implements Quinable, SelfSourceable, SelfWritable, QuineMirrorable{
    public MindBend(){}
    
    /**
     * Writes the source code to a file.
     * If mirrored is true, it writes it to a file with a reversed name and reversed line order.
     *
     * @param mirroredP whether to reverse the output file name and contents
     */
    @Override
    public void writeSelf(boolean mirroredP)
    {
        try {
            FileWriter exportingFileWriter;
            if (!mirroredP) exportingFileWriter = new FileWriter("MindBend.java"); 
            else exportingFileWriter = new FileWriter("avaj.dneBdniM");
            BufferedWriter exportingBufferedWriter = new BufferedWriter(exportingFileWriter);
            if (!mirroredP) exportingBufferedWriter.write(printSelf());
            else exportingBufferedWriter.write(printSelfMirror());
            exportingBufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Reads the actual source code from the file system.
     * This is the "cheat" way of getting the source code. However, it's strictly
     * here for demonstration and comparison. The actual Quine capabilities of
     * this class (like printSelf) do NOT rely on this file reading cheat; they
     * generate the source code purely from memory!
     *
     * @return the contents of the MindBend.java file
     */
    @Override
    public String getSourceCode(){
        String toReturn="";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("src\\MindBend.java"));
            String currentLine = br.readLine();
            while(currentLine!=null)
            {
                toReturn += currentLine+'\n';
                currentLine = br.readLine();
            }
            br.close();
        }
        catch (FileNotFoundException e){System.out.println("The file was not found. Please try another file.");}
        catch (IOException e){e.printStackTrace();}
        return toReturn;
    }
    
    /**
     * Generates the source code of this class entirely from memory,
     * without reading from the file system.
     *
     * @return the generated source code string
     */
    @Override
    public String printSelf(){
        String toReturn = "";
        for (String s: getSelf(true))toReturn+=s;
        return toReturn;
    }
    
    /**
     * Generates the source code of this class entirely from memory,
     * but with the lines arranged in reverse order.
     *
     * @return the reversed generated source code string
     */
    @Override
    public String printSelfMirror() {
        String toReturn = "";
        for (String s: getSelf(false))toReturn+=s;
        return toReturn;
    }
    
    /**
     * The core Quine logic. It contains a string array of its own source code,
     * minus the contents of the string array itself. It then iterates through
     * the array and dynamically reconstructs the entire file.
     *
     * @param forwardOrBackWardP true for normal output, false for reversed line output
     * @return an ArrayList containing the generated lines of code
     */
    private ArrayList<String> getSelf(boolean forwardOrBackWardP) {
        String[] str = {
                "///////////////////////////////////////////////////////////////////////////////",
                "// CS302 Summer 2013 - Project 5",
                "// Author: Nick Pappas",
                "//",
                "// (You guys put your wisc.edu email here.)",
                "// (Credits here, if you got help from anyone but me)",
                "///////////////////////////////////////////////////////////////////////////////",
                "",
                "import java.io.BufferedReader;",
                "import java.io.BufferedWriter;",
                "import java.io.FileNotFoundException;",
                "import java.io.FileReader;",
                "import java.io.FileWriter;",
                "import java.io.IOException;",
                "import java.util.ArrayList;",
                "",
                "/**",
                " * A self-replicating Quine class that can print its own source code,",
                " * read its own source code file, and write itself to a new file.",
                " * Crucially, it also features QuineMirrorable functionality, allowing it to",
                " * write its source code backwards (both reversed lines and reversed filename).",
                " */",
                "public class MindBend implements Quinable, SelfSourceable, SelfWritable, QuineMirrorable{",
                "    public MindBend(){}",
                "    ",
                "    /**",
                "     * Writes the source code to a file.",
                "     * If mirrored is true, it writes it to a file with a reversed name and reversed line order.",
                "     *",
                "     * @param mirroredP whether to reverse the output file name and contents",
                "     */",
                "    @Override",
                "    public void writeSelf(boolean mirroredP)",
                "    {",
                "        try {",
                "            FileWriter exportingFileWriter;",
                "            if (!mirroredP) exportingFileWriter = new FileWriter(\"MindBend.java\"); ",
                "            else exportingFileWriter = new FileWriter(\"avaj.dneBdniM\");",
                "            BufferedWriter exportingBufferedWriter = new BufferedWriter(exportingFileWriter);",
                "            if (!mirroredP) exportingBufferedWriter.write(printSelf());",
                "            else exportingBufferedWriter.write(printSelfMirror());",
                "            exportingBufferedWriter.close();",
                "        } catch (IOException e) {",
                "            e.printStackTrace();",
                "        }",
                "    }",
                "    ",
                "    /**",
                "     * Reads the actual source code from the file system.",
                "     * This is the \"cheat\" way of getting the source code. However, it's strictly",
                "     * here for demonstration and comparison. The actual Quine capabilities of",
                "     * this class (like printSelf) do NOT rely on this file reading cheat; they",
                "     * generate the source code purely from memory!",
                "     *",
                "     * @return the contents of the MindBend.java file",
                "     */",
                "    @Override",
                "    public String getSourceCode(){",
                "        String toReturn=\"\";",
                "        try",
                "        {",
                "            BufferedReader br = new BufferedReader(new FileReader(\"src\\\\MindBend.java\"));",
                "            String currentLine = br.readLine();",
                "            while(currentLine!=null)",
                "            {",
                "                toReturn += currentLine+'\\n';",
                "                currentLine = br.readLine();",
                "            }",
                "            br.close();",
                "        }",
                "        catch (FileNotFoundException e){System.out.println(\"The file was not found. Please try another file.\");}",
                "        catch (IOException e){e.printStackTrace();}",
                "        return toReturn;",
                "    }",
                "    ",
                "    /**",
                "     * Generates the source code of this class entirely from memory,",
                "     * without reading from the file system.",
                "     *",
                "     * @return the generated source code string",
                "     */",
                "    @Override",
                "    public String printSelf(){",
                "        String toReturn = \"\";",
                "        for (String s: getSelf(true))toReturn+=s;",
                "        return toReturn;",
                "    }",
                "    ",
                "    /**",
                "     * Generates the source code of this class entirely from memory,",
                "     * but with the lines arranged in reverse order.",
                "     *",
                "     * @return the reversed generated source code string",
                "     */",
                "    @Override",
                "    public String printSelfMirror() {",
                "        String toReturn = \"\";",
                "        for (String s: getSelf(false))toReturn+=s;",
                "        return toReturn;",
                "    }",
                "    ",
                "    /**",
                "     * The core Quine logic. It contains a string array of its own source code,",
                "     * minus the contents of the string array itself. It then iterates through",
                "     * the array and dynamically reconstructs the entire file.",
                "     *",
                "     * @param forwardOrBackWardP true for normal output, false for reversed line output",
                "     * @return an ArrayList containing the generated lines of code",
                "     */",
                "    private ArrayList<String> getSelf(boolean forwardOrBackWardP) {",
                "        String[] str = {",
                "        };",
                "        ArrayList<String> out=new ArrayList<String>();",
                "        String q = String.valueOf((char)34);",
                "        String b = String.valueOf((char)92);",
                "        if (forwardOrBackWardP)",
                "        {",
                "            for(int i=0;i<111;i++)out.add(str[i]+'\\n');",
                "            for(int i=0;i<137;i++)out.add(\"                \"+q+str[i].replace(b, b+b).replace(q, b+q)+q+','+'\\n');",
                "            for(int i=111; i<str.length; i++)out.add(str[i]+'\\n');",
                "        }",
                "        else",
                "        {",
                "            for(int i=str.length-1; i>=111; i--)out.add(str[i]+'\\n');",
                "            for(int i=136;i>=0;i--)out.add(\"                \"+q+str[i].replace(b, b+b).replace(q, b+q)+q+','+'\\n');",
                "            for(int i=110;i>=0;i--)out.add(str[i]+'\\n');",
                "        }",
                "        return out;",
                "    }",
                "    public static void main(String[] args) {",
                "        System.out.println(new MindBend().getSourceCode());",
                "        System.out.println(new MindBend().printSelf());",
                "        System.out.println(new MindBend().printSelfMirror());",
                "        new MindBend().writeSelf(true);",
                "        new MindBend().writeSelf(false);",
                "    }",
                "}",
        };
        ArrayList<String> out=new ArrayList<String>();
        String q = String.valueOf((char)34);
        String b = String.valueOf((char)92);
        if (forwardOrBackWardP)
        {
            for(int i=0;i<111;i++)out.add(str[i]+'\n');
            for(int i=0;i<137;i++)out.add("                "+q+str[i].replace(b, b+b).replace(q, b+q)+q+','+'\n');
            for(int i=111; i<str.length; i++)out.add(str[i]+'\n');
        }
        else
        {
            for(int i=str.length-1; i>=111; i--)out.add(str[i]+'\n');
            for(int i=136;i>=0;i--)out.add("                "+q+str[i].replace(b, b+b).replace(q, b+q)+q+','+'\n');
            for(int i=110;i>=0;i--)out.add(str[i]+'\n');
        }
        return out;
    }
    public static void main(String[] args) {
        System.out.println(new MindBend().getSourceCode());
        System.out.println(new MindBend().printSelf());
        System.out.println(new MindBend().printSelfMirror());
        new MindBend().writeSelf(true);
        new MindBend().writeSelf(false);
    }
}