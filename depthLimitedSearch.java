/**
* This is the main class that produces the optimal (hopefully)
* solution to the problems stored in the file questions.txt
* in the triangle graph of the file triangles.txt
* it then outputs each solution into the questions folder in a file
* with the questions no e.g. 1.txt,2.txt etc
*
* @author  George Calnan
* @version 1.0
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DepthLimitedSearch{
  ArrayList<ArrayList<Vertex>> triangles;
  ArrayList<ArrayList<Vertex>> questions;

  HashMap<String,ArrayList<Vertex>> network;

  public static void main(String[] args){
    DepthLimitedSearch dls = new DepthLimitedSearch();
    dls.init();
  }

  /*
  * nextConfig returns all the reachable vertices from the given node using
  *   the network
  *
  * @param cNode this is the current node or vertex that we are at
  * @return a list of all the reachable vertices
  */
  private ArrayList<Vertex> nextConfig(Vertex cNode){
    return network.get(cNode.toString());
  }

  /*
  * verticesEqual tests whether two given vertices are equal or not
  *
  * @param v1, v2 the two vertices that are being compared
  * @return boolean whether the two are equal/true or not/false
  */
  public boolean verticesEqual(Vertex v1, Vertex v2){
    return v1.get_x() == v2.get_x() && v1.get_y() == v2.get_y();
  }

  /*
  * DLS (Depth-Limited-Search) is a recursive function implimenting a
  * depth limited search, it does this by checking if the limit is reached
  * if it is it returns an empty array. If the node is the end it returns
  * a list containing itself, if it is not the finish node it calls the function
  * on all the nodes reachable from it. If any of these return an array that
  * is not empty it tacks itself onto the beginning of the path and returns it.
  * This builds a path.
  *
  * @param cNode or Current Node is the node that we are looking at right now
  * @param fNode or Finish Node is the goal we are trying to reach
  * @param limit is the path limit
  * @return ArrayList<String> this is a list of vertices that make up the path
  */
  private ArrayList<String> DLS(Vertex cNode,Vertex fNode,int limit){
    if(limit <= 0){
      return new ArrayList<String>();
    } else if(verticesEqual(cNode,fNode)){
        ArrayList<String> path = new ArrayList<String>();
        path.add(cNode.toString());
        return path;
    } else {
      for(Vertex nNode : nextConfig(cNode)){
        ArrayList<String> path = DLS(nNode,fNode,limit-1);
        if(path.size() != 0){
          path.add(0,cNode.toString());
          return path;
        }
      }
      return new ArrayList<String>();
    }
  }

  /*
  * solvePath solves the question of the optimal path between the two nodes given
  *
  * @param sNode this is the start node
  * @param fNode this is the finish node
  */
  private ArrayList<String> solvePath(Vertex sNode, Vertex fNode, int maxLimit){
    for(int i = 0; i < maxLimit;i++){
      ArrayList<String> path = DLS(sNode,fNode,i);
      if(path.size() != 0){
        return path;
      }
    }
    System.out.println("No Path Could be Found from:" + sNode + " to:" + fNode);
    System.out.println("This is a big problem");
    System.exit(0);
    return null;
  }

  /*
  * init is the function that initiates the depth limited search and calls
  * the relevent functions. It also writes all the answers to the
  * respective files.
  */
  public void init(){
    triangles = FileHandler.readTrianglesFile();
    questions = FileHandler.readQuestionsFile();
    NetworkMaker nh = new NetworkMaker(triangles);
    network = nh.buidNetwork();
    int maxLimit = 0;
    for(ArrayList<Vertex> i: triangles){
      for(Vertex j: i){
        maxLimit++;
      }
    }

    for(ArrayList<Vertex> que:questions){
      Vertex sNode = que.get(0); //Start Node
      Vertex fNode = que.get(1); //Finish Node
      //Write this to a file
      solvePath(sNode,fNode,maxLimit);
    }
  }
}
