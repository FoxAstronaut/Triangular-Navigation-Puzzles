# Triangular Navigation Puzzles
## How To Run
To run this application there is a main method for the class Triangular_Naviagtion_Puzzles running this will output the solutions to the questions in the file questions.txt in the triangle field stored in triangles.txt. These solutions will be outputted into the folder solutions with each solution being in a folder marked with its number e.g. 0.txt,1.txt etc.

## Method
### Network Maker
To improve efficiency when computing every reachable vertex when finding a solution so instead we just find every reachable vertex from every other vertex. This is stored in a HashMap so that the key is the vertex and the value is a list of all reachable vertices from that vertex:
| Key      |         Value        |
|----------|:--------------------:|
| (16, 19) | [(17, 19), (14, 20)] |

### Depth Limited Search
To find the solutions to the problems we use a recursive function. The function is first called with the start vertex and the current path limit (started at 0) it checks the path limit is not 0 otherwise it returns an empty array. It also calls the function on all its reachable vertices, returned by the nextConfig method. If a vertex sees that it is the end vertex it will return a list of itself. All the functions that called that will then tack their vertex onto the front of the list to create the path. If no path can be found and the limit is reached, the limit is the number of all vertices in the puzzle, if this is reached then we have a big problem, as per discussion with Andy King all questions should have a solution.

## Note
I have used the term node such as cNode, sNode & fNode in place of vertex as I use a network.
