import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileHandler{
  public static void main(String[] args){
    readTrianglesFile();
    readQuestionsFile();
  }

  /*
  * readTrianglesFile returns the triangles table stored in the files
  *   triangle.txt and returns it in the format of a list of 3 vertices
  *
  * @return a 2d array of all vertex where each list represents a triangle
  */
  public static ArrayList<ArrayList<Vertex>> readTrianglesFile(){
    BufferedReader br = null;
		FileReader fr = null;
    String filename = "triangles.txt";
    ArrayList<ArrayList<Vertex>> triangles = new ArrayList<ArrayList<Vertex>>();
		try {
			br = new BufferedReader(new FileReader(filename));
			String line;
      ArrayList<Vertex> triangle;
			while ((line = br.readLine()) != null) {
        triangle = new ArrayList<Vertex>();
        line = line.replaceAll("\\d+\\s", "");
        String[] lines = line.split("([\\)]\\s[\\(])");
				for(String l:lines){
          l = l.replaceAll("[\\)]|[\\(]|\\s", "");
          String[] ls = l.split(",");
          Vertex v = new Vertex(Integer.parseInt(ls[0]),Integer.parseInt(ls[1]));
          triangle.add(v);
        }
        triangles.add(triangle);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
    return triangles;
  }

  /*
  * readQuestionsFile returns the question table stored in the files
  *   questions.txt and returns it in the format of a list of 2 vertices
  *   for the start and the end
  *
  * @return a 2d array of all vertex where each list represents a question
  */
  public static ArrayList<ArrayList<Vertex>> readQuestionsFile(){
    BufferedReader br = null;
		FileReader fr = null;
    String filename = "questions.txt";
    ArrayList<ArrayList<Vertex>> questions = new ArrayList<ArrayList<Vertex>>();
		try {
			br = new BufferedReader(new FileReader(filename));
			String line;
      ArrayList<Vertex> question;
			while ((line = br.readLine()) != null) {
        question = new ArrayList<Vertex>();
        line = line.replaceAll("\\d+\\s", "");
        String[] lines = line.split("([\\)]\\s[\\(])");
				for(String l:lines){
          l = l.replaceAll("[\\)]|[\\(]|\\s", "");
          String[] ls = l.split(",");
          Vertex v = new Vertex(Integer.parseInt(ls[0]),Integer.parseInt(ls[1]));
          question.add(v);
        }
        questions.add(question);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
    return questions;
  }
}
