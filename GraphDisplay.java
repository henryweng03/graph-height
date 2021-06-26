import java.util.*;

public class GraphDisplay{

    Graph g;

    //helps us convert Strings to Integer
    HashMap<String, Integer> nodeMap;
    int[][] adjMatrix;
    int numNodes;
    int[] height;
    int stepSize = 1;

    
    public GraphDisplay(Graph gr){
        g = gr;
        numNodes = g.nodes.length;
        nodeMap = new HashMap<>();
        adjMatrix = new int[numNodes][numNodes];
        height = new int[numNodes];

        for(int i = 0; i < numNodes; i++){
            nodeMap.put(g.nodes[i], i);
        }

        //adjMatrix[i][j] == 1 if there is a edge from i to j
        for(int i = 0; i < g.edges.length; i++){
            adjMatrix[nodeMap.get(g.edges[i].from)][nodeMap.get(g.edges[i].to)] = 1;
        }
    }
    
    public void findCoords(){
        
        Coords[] coordList = new Coords[numNodes];
        for(int i = 0; i < numNodes; i++){
            getHeight(i);
        }

    }

    public int getHeight(int nodeNumber){
        if(height[nodeNumber] != 0){
            return height[nodeNumber];
        }
        int[] children = findChildren(nodeNumber);
        if(children.length == 0){
            if(hasParents(nodeNumber) == false){
                height[nodeNumber] = -1;
                return -1;
            }
            height[nodeNumber] = stepSize;
            return stepSize;
        } else {
            int max = 0;
            for (int i : children) {
                max = Math.max(max, getHeight(i));
            }
            height[nodeNumber] = max + stepSize;
            return max + stepSize;
        }
    }

    public int[] findChildren(int nodeNumber){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < numNodes; i++){
            if(adjMatrix[nodeNumber][i] == 1){
                result.add(i);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public boolean hasParents(int nodeNumber){
        for(int i = 0; i < numNodes; i++){
            if(adjMatrix[i][nodeNumber] == 1){
                return true;
            }
        }
        return false;
    }

}