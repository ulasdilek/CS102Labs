package lab05;

//********************************************************************
//  MazeSearch.java       Author: Lewis/Loftus
//
//  Demonstrates recursion.
//********************************************************************

public class MazeSearch
{
   //-----------------------------------------------------------------
   //  Creates a new maze, prints its original form, attempts to
   //  solve it, and prints out its final form.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      // test 1
      // Maze labyrinth = new Maze(new int[][] {{1, 0, 0, 0, 0, 0},
      //                                        {1, 1, 1, 0, 0, 0},
      //                                        {0, 0, 0, 0, 1, 1}});
      // labyrinth.add(new Portal (new int[] {1, 2}, new int[] {2, 4}));

      // test 2
      // Maze labyrinth = new Maze(new int[][] {{1, 1, 0, 0, 0, 0},
      //                                        {1, 1, 1, 1, 1, 0},
      //                                        {1, 1, 1, 1, 1, 0},
      //                                        {0, 0, 0, 1, 1, 1}});
      // labyrinth.add(new Portal (new int[] {1, 2}, new int[] {2, 3}));

      // test 3
      // Maze labyrinth = new Maze(new int[][] {{1, 1, 1, 1, 1, 1},
      //                                        {0, 1, 1, 1, 1, 1},
      //                                        {0, 1, 0, 0, 0, 0},
      //                                        {0, 0, 0, 1, 0, 1}});
      // labyrinth.add(new Portal (new int[] {0, 3}, new int[] {3, 3}));

      // test 4
      Maze labyrinth = new Maze(new int[][] {{1, 1, 0, 1, 1, 1},
                                             {0, 0, 0, 0, 0, 1},
                                             {0, 0, 0, 1, 0, 0},
                                             {0, 0, 0, 0, 0, 0},
                                             {1, 1, 0, 0, 1, 1}});
      labyrinth.add(new Portal (new int[] {0, 1}, new int[] {0, 3}));
      labyrinth.add(new Portal (new int[] {1, 5}, new int[] {4, 0}));
      labyrinth.add(new Portal (new int[] {4, 1}, new int[] {4, 4}));
      
      System.out.println (labyrinth);

      if (labyrinth.traverse (0, 0))
         System.out.println ("The maze was successfully traversed!");
      else
         System.out.println ("There is no possible path.");

      // if there is 3 in the traversal map, it means that a portal entry was used at that location
      System.out.println (labyrinth);
   }
}
