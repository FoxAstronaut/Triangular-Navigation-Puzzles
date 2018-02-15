import java.util.ArrayList;
import java.util.Arrays;

public class depthLimitedSearch{
  Vertex[][] triangles = {
    {new Vertex(11, 0),new Vertex(13, 1),new Vertex(18, 5)},
    {new Vertex(5, 4),new Vertex(7, 9),new Vertex(5, 8)},
    {new Vertex(2, 3),new Vertex(4, 11),new Vertex(2, 6)},
    {new Vertex(13, 7),new Vertex(14, 9),new Vertex(17, 10)},
    {new Vertex(4, 9),new Vertex(11, 16),new Vertex(9, 11)},
    {new Vertex(11, 3),new Vertex(19, 7),new Vertex(18, 10)},
    {new Vertex(14, 10),new Vertex(17, 12),new Vertex(22, 11)},
    {new Vertex(3, 1),new Vertex(12, 9),new Vertex(6, 9)},
    {new Vertex(9, 11),new Vertex(14, 12),new Vertex(14, 19)},
    {new Vertex(12, 2),new Vertex(18, 7),new Vertex(20, 8)},
    {new Vertex(3, 3),new Vertex(10, 6),new Vertex(12, 8)},
    {new Vertex(9, 15),new Vertex(16, 19),new Vertex(14, 15)},
    {new Vertex(11, 2),new Vertex(18, 6),new Vertex(11, 3)},
    {new Vertex(11, 11),new Vertex(20, 12),new Vertex(13, 17)},
    {new Vertex(13, 16),new Vertex(17, 19),new Vertex(14, 20)},
  };

  public static void main(String[] args){
    depthLimitedSearch dls = new depthLimitedSearch();
    dls.test();
    dls.depthLimitedSearch();
  }

  public void test(){
    System.out.println("Starting");
  }

  public void depthLimitedSearch(){
    //A path will be kept in an array with each part changing its section
    //Each time we change a bit of the path it clears the later path bits
    //Check if a path of 0 works
    //Basically is the start node the end node
    //If not Then
    //Check all paths of length 1
    //Use nextConfig to find all the reachable paths from the start
    //If any of these are the end then return that path

    //Example:
    //Problem 9: (11,3) to (14,20)
    //Path = [(11,3)]
    //Check paths of length 0
    //Is (11,3) = (14,20) - No
    //Check paths of length 1
    //Next configs = [(3,1),(10,6),(12,8)...]
    //Path = [(11,3),(3,1) or (10,6) or (12,8)]
    //Is any of these = (14,20) - No
    //Check paths of length 2
    //Continue until the end is first found
    //Return the path
    Vertex sNode = new Vertex(13, 1);
    Vertex fNode = new Vertex(5, 20);
    ArrayList<Vertex> path = new ArrayList<Vertex>();
    path.add(sNode);
    Vertex cNode = sNode;

    while(cNode != fNode){
      //Should be unreachable
      System.out.println(checkReachable(new Vertex(13, 1),new Vertex(5, 20)));
      //Should be reachable
      System.out.println(checkReachable(new Vertex(14, 20),new Vertex(17, 19)));
      //nextConfig(cNode);
      break;
    }
  }

  private boolean checkReachable(Vertex v1, Vertex v2){
    //For each triangle check if the line intersects any of its edges
    for(Vertex[] tri : triangles){
      //Check each of the three edges
      for(int i = 0; i < tri.length; i++){
        int index = i+1;
        if(index == tri.length){
          index = 0;
        }
        //Check if the line intersects the triangle line of
        //I and Index
      }
    }
    return true;
  }

  private Vertex[] nextConfig(Vertex cNode){
    //Return a list of all the reachable nodes
    //By iterating through all the verticies
    //And checking them against the list of triangles to see if
    //The current node to the next possible node intersects
    //Any of the lines of a triangle
    //So check vertex 0 to vertex 1 of the triangle then
    //Vertex 1 to vertex 2 of the triangle
    //Then check vertex 2 to vertex 0
    //If it doesnt intersect any of these then its added
    //To an array of next vertices

    for(Vertex[] vertices : triangles){
      for(Vertex nNode : vertices)
      //For all the vertices check if they are reachable
      //They cannot be the current node

      if(nNode.get_x() != cNode.get_x() && nNode.get_y() != cNode.get_y()){
        //Make sure we are not checking the current node
      }
    }
    return null;
  }
}
