import org.graalvm.compiler.graph.Node;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;
import java.util.*;
public class Driver {
    public static void main(String[] args){
        String[] testNodes = new String[11];
        testNodes[0] = "mic";
        testNodes[1] = "mic2";
        testNodes[2] = "cc";
        testNodes[3] = "srch";
        testNodes[4] = "ls";
        testNodes[5] = "mic1";
        testNodes[6] = "kb";
        testNodes[7] = "bb";
        testNodes[8] = "mic3";
        testNodes[9] = "bb1";
        testNodes[10] = "kb1";
        Edge[] testEdges = new Edge[7];
        testEdges[0] = new Edge("mic", "cc");
        testEdges[1] = new Edge("mic1", "cc");
        testEdges[2] = new Edge("cc", "srch");
        testEdges[3] = new Edge("cc", "ls");
        testEdges[4] = new Edge("srch", "mic2");
        testEdges[5] = new Edge("ls", "kb");
        testEdges[6] = new Edge("ls", "bb");
        Graph test = new Graph(testEdges, testNodes);
        GraphDisplay display = new GraphDisplay(test);
        display.findCoords();

        System.out.println(Arrays.toString(display.height));
    }
}
