/**
* This class produces a network stored in a HashMap
* this network represents each vertex and all the verticies
* that are reachable from that vertex. Using this helps reduce
* the redundency of recomputing the reachable node for every question
*
* @author  George Calnan
* @version 1.0
*/

import java.util.ArrayList;
import java.util.HashMap;

public class NetworkMaker{
  ArrayList<ArrayList<Vertex>> triangles;

  public static void main(String[] args){
    System.out.println("Working!!");
  }

  public NetworkMaker(ArrayList<ArrayList<Vertex>> tri){
    triangles = tri;
  }

  /*
  * checkReachable checks if a line intersects any of the edges of all
  *   the triangles in the triangles array
  *
  * @param v1, v2 are each vertices that represent the start and the end of
  *   the line that we are checking
  * @return boolean of whether the line intersects any triangle. False if
  *   unreachable & true if it is reachable. Reachable means there is
  *   no triangle that intersects the line
  */
  private boolean checkReachable(Vertex v1, Vertex v2){
    for(ArrayList<Vertex> tri : triangles){
      for(int i = 0; i < tri.size(); i++){
        int j = i+1;
        if(j == tri.size()){
          j = 0;
        }
        if(Vertex.vertexInterior(v2,tri.get(0),tri.get(1),tri.get(2)) || Vertex.linesIntersect(v1,v2,tri.get(i),tri.get(j))){
          return false;
        }
      }
    }
    return true;
  }

  /*
  * nextConfig finds all the reachable vertices from the current vertex
  *
  * @param cNode represents the vertex or node that we are looking from
  * @return list of vertices that a reachable/could be the next config of
  *   this vertex
  */
  private ArrayList<Vertex> nextConfig(Vertex cNode){
    ArrayList<Vertex> nextConfigs = new ArrayList<Vertex>();

    for(ArrayList<Vertex> vertices : triangles){
      for(Vertex nNode : vertices)
      if(nNode.get_x() != cNode.get_x() || nNode.get_y() != cNode.get_y()){
        if(checkReachable(cNode,nNode)){
          nextConfigs.add(nNode);
        }
      }
    }
    return nextConfigs;
  }

  /*
  * buildNetwork creates a hashmap that represents a network of vertices
  *   the network holds the vertex as its key and a list of verticices
  *   that a reachable from that vertex
  *
  * @return hashmap of vertex and a list of verticies
  */
  public HashMap<String,ArrayList<Vertex>> buidNetwork(){
    //This might be a bit of a unncessery quad nested loop but its
    // the best I got
    HashMap<String,ArrayList<Vertex>> network = new HashMap<String,ArrayList<Vertex>>();
    //Loop through all the vertices in the triangles array
    for(ArrayList<Vertex> vertices : triangles){
      for(Vertex cNode : vertices){
        network.put(cNode.toString(),nextConfig(cNode));
      }
    }
    return network;
  }
}
