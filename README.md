# Triangular Navigation Puzzles
## Requirements
1. The algorithm must output the most optimal solution. Measured by the number of line segments.
2. A line cannot enter the interior of a triangle. Triangles are defined by their three vertices.
3. A line can intersect the edge or vertex of a triangle
4. The algorithm must include a nextConfig function which gives the adjacent or reachable states
5. The Java must include a main function so that it can be run without BlueJ
6. The algorithm should be documented (but not excessively), efficient and also as brief as needed will get the highest marks. Or as put in the assignment “Code that is clear, elegant and succinct will attract the highest marks”
7. An effort should be made to make the code more efficient but making drastic changes with a small impact is discouraged. Or as put in the assignment “Minor changes to the code that significantly improve efficiency are encouraged; major changes that have a minor impact on efficiency are discouraged.”

## Method
Depth-Limited Search
Using a depth-limited search method to search all paths of 1,2,3,4 … n-1 length before checking n will find the optimum path
