import static java.lang.System.*;
import java.io.*;
import java.util.*;

class Memory_Game extends preGame{

  public static void main(String[] args){
    gameplay(); // from preGame class
  }

  // loads x amount of words into array and then shuffles it
  static String[] load(int arrayLength){
    String WordArray1[] = new String[arrayLength];
    // reads from text file and adds to array:
    try{
      FileInputStream fis = new FileInputStream("foods.txt");
      Scanner scanIn = new Scanner(fis);
      // adds words in text file to array:
      for (int i=0;i<WordArray1.length; i++){
        if (scanIn.hasNext()){
          WordArray1[i] = scanIn.nextLine();
        }
      }

  } catch (IOException e){
    out.println("\nERROR: file not found. please make sure text file is in proper folder.\n");
    return null;
    }

    return shuffleArray(WordArray1);
  }

  // shuffles array:
  static String[] shuffleArray(String[] arr){
    Random rand  = new Random();
    int r = 0;
    String temp;
    for (int i=0;i<arr.length;i++){
      // picks random int from 0 to 50
      r = rand.nextInt(arr.length-1);
      temp = arr[i];
      arr[i] = arr[r];
      arr[r] = temp;
    }

    return arr;
  }

  static int seconds = 1;
  // timer that uses the Thread module:
  static void startTimer(int sec){
    try{
      Thread Y = new Thread();

      // inputted "sec" will determine how long timer will go for
      while (seconds <= sec){
        // timer sleeps for 1 second before starting:
        Y.sleep(1000);
        out.println("Seconds Passed: " + seconds);
        seconds++;
      }

      seconds = 1;
    } catch (Exception e){}
  }

  // creates array for grid
  // options for this parameter are 4, 6, 8 but also vary depending on file read from
  static String[][] loadArray(int gridSize){
    // numWords = number of words in arr
    int numWords = (gridSize*gridSize) / 2;
    int remain = numWords;
    int foo = 0;
    int n = 0;
    // loads x amount of words into temp array:
    String[] temp = load(numWords);
    // Creates new array and fills it with the theme "foods(%d)":
    String[] face = new String[temp.length * 2];
    // creates unique identity for each face
    for (int i=0; i<face.length; i++){
      // this makes face cards say "foods(1)" and etc but is therefore limited to only a foods theme
      String theme = String.format("foods(%d)", n);
      face[i] = theme;
      n++;
    }
    // creates x length array of words:
    String[] words = Arrays.copyOf(temp, temp.length * 2);
    String[][] visibleArray = {face, words};
    // fills in all the blank indexes in words array:
    for (int i=remain;i<words.length; i++){
      words[i] = temp[foo];
      foo++;
    }

    return visibleArray;
    // should look something like this:
    // [[foods(0), foods(1), foods(2), foods(3), foods(4)...]], [Avocado, Apricot, Durian, Apple, Cherry, Banana...]]
    // first array in 2d array should be face value while the second array contains true value

  } // end loadArray()


  // takes 2d array(see loadArray) and formats it into a 4x4 grid (String type)
  static String grid4x4(String[][] visibleArray){
    String grid = String.format(
    "_____________________________________________________"
    + "\n%s\t\t%s\t\t%s\t\t%s\n\n"
    + "%s\t\t%s\t\t%s\t\t%s\n\n"
    + "%s\t\t%s\t\t%s\t\t%s\n\n"
    + "%s\t\t%s\t\t%s\t\t%s\n\n"
    + "___________________________________________________",
    visibleArray[0][0], visibleArray[0][1], visibleArray[0][2], visibleArray[0][3],
    visibleArray[0][4], visibleArray[0][5], visibleArray[0][6], visibleArray[0][7],
    visibleArray[0][8], visibleArray[0][9], visibleArray[0][10], visibleArray[0][11],
    visibleArray[0][12], visibleArray[0][13], visibleArray[0][14], visibleArray[0][15]
    );

    return grid;
  }

  // takes 2d array(see loadArray) and formats it into a 6x6 grid (String type)
  static String grid6x6(String[][] visibleArray){
    String grid = String.format(
    "___________________________________________________________________________"
    + "\n%s\t%s\t%s\t%s\t%s\t%s\n\n"
    + "%s\t%s\t%s\t%s\t%s\t%s\n\n"
    + "%s\t%s\t%s\t%s\t%s\t%s\n\n"
    + "%s\t%s\t%s\t%s\t%s\t%s\n\n"
    + "%s\t%s\t%s\t%s\t%s\t%s\n\n"
    + "%s\t%s\t%s\t%s\t%s\t%s\n\n"
    + "_________________________________________________________________________",
    visibleArray[0][0], visibleArray[0][1], visibleArray[0][2], visibleArray[0][3],
    visibleArray[0][4], visibleArray[0][5], visibleArray[0][6], visibleArray[0][7],
    visibleArray[0][8], visibleArray[0][9], visibleArray[0][10], visibleArray[0][11],
    visibleArray[0][12], visibleArray[0][13], visibleArray[0][14], visibleArray[0][15],
    visibleArray[0][16], visibleArray[0][17], visibleArray[0][18], visibleArray[0][19],
    visibleArray[0][20], visibleArray[0][21], visibleArray[0][22], visibleArray[0][23],
    visibleArray[0][24], visibleArray[0][25], visibleArray[0][26], visibleArray[0][27],
    visibleArray[0][28], visibleArray[0][29], visibleArray[0][30], visibleArray[0][31],
    visibleArray[0][32], visibleArray[0][33], visibleArray[0][34], visibleArray[0][35]
    );

    return grid;
  }

  // takes 2d array(see loadArray) and formats it into a 6x6 grid (String type)
  static String grid8x8(String[][] visibleArray){
    String grid = String.format(
    "___________________________________________________________________________"
    + "\n%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n\n"
    + "%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n\n"
    + "%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n\n"
    + "%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n\n"
    + "%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n\n"
    + "%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n\n"
    + "%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n\n"
    + "%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n\n"
    + "_________________________________________________________________________",
    visibleArray[0][0], visibleArray[0][1], visibleArray[0][2], visibleArray[0][3],
    visibleArray[0][4], visibleArray[0][5], visibleArray[0][6], visibleArray[0][7],
    visibleArray[0][8], visibleArray[0][9], visibleArray[0][10], visibleArray[0][11],
    visibleArray[0][12], visibleArray[0][13], visibleArray[0][14], visibleArray[0][15],
    visibleArray[0][16], visibleArray[0][17], visibleArray[0][18], visibleArray[0][19],
    visibleArray[0][20], visibleArray[0][21], visibleArray[0][22], visibleArray[0][23],
    visibleArray[0][24], visibleArray[0][25], visibleArray[0][26], visibleArray[0][27],
    visibleArray[0][28], visibleArray[0][29], visibleArray[0][30], visibleArray[0][31],
    visibleArray[0][32], visibleArray[0][33], visibleArray[0][34], visibleArray[0][35],
    visibleArray[0][36], visibleArray[0][37], visibleArray[0][38], visibleArray[0][39],
    visibleArray[0][40], visibleArray[0][41], visibleArray[0][42], visibleArray[0][43],
    visibleArray[0][44], visibleArray[0][45], visibleArray[0][46], visibleArray[0][47],
    visibleArray[0][48], visibleArray[0][49], visibleArray[0][50], visibleArray[0][51],
    visibleArray[0][52], visibleArray[0][53], visibleArray[0][54], visibleArray[0][55],
    visibleArray[0][56], visibleArray[0][57], visibleArray[0][58], visibleArray[0][59],
    visibleArray[0][60], visibleArray[0][61], visibleArray[0][62], visibleArray[0][63]
    );

    return grid;
  }
} // end main class

// prompts user to select game conditions
class preGame{

  static String title = "\nFOODS MEMORY MATCHING GAME!\n";
  static String m1 = "'4' - 4x4 Grid (easy)\n'6' - 6x6 Grid (medium)\n'8' - 8x8 Grid (difficult)";
  static String m2 = "'6' - 6 Seconds (easy)\n'4' - 4 Seconds (medium)\n'2' - 2 Seconds (difficult)";
  static String choices = "648";
  static String choices2 = "642";
  static int n2;
  static int n1;

  // first menu that prompts user
  static int menu1(){
    Scanner scanIn = new Scanner(System.in);
    out.println(title);
    out.println(m1);
    out.print("\nPlease Select one of the options above.\nOption chosen: ");
    n1 = scanIn.nextInt();

    return n1;
  }
  // second menu that prompts user:
  static int menu2(){
    Scanner scanIn = new Scanner(System.in);
    out.println("\n" + m2);
    out.print("\nPlease Select one of the options above.\nOption chosen: ");
    n2 = scanIn.nextInt();

    return n2;
  }
  // main interface that connects menus and games together
  static void gameplay(){
    while (true){
      int foo = menu1();
      // determines whether or not user input for menu 1 is valid:
      if (foo==4 || foo==6 || foo==8){
        while (true){
          String foo2 = String.valueOf(menu2());
          // determines whether or not user input for menu 2 is valid:
          if (choices2.contains(foo2)){
            // converts int to String
            int difficulty = Integer.parseInt(foo2);
            out.println("\nLETS BEGIN!\n");
            gridGamePlay.grid(difficulty,foo);
            break;
          }
          else {
            out.println("INVALID OPTION!!!\n");
          }
        }
          break;
        }

      else {
        out.println("INVALID OPTION!!!\n");
      }

    }
  }

} // end preGame

// class for the gameplay when player begins to select tiles
class gridGamePlay extends Memory_Game{

  static void grid(int difficulty, int size){

    // see "loadArray" method for more details on "visibleArray"
    String [][] visibleArray = loadArray(size);

    String grid = redefineGrid(visibleArray, size);
    int selectedSquare1;
    int selectedSquare2;
    String face = "foods";

    // checks to see whether or not the game has finished
    while (true){
      // completed will always be 16 in a 4x4 grid and so on
      int completed = visibleArray[1].length;
      // loops through first array(face) in visible array
      for (String i : visibleArray[0]){
        // checks to see if any values contains the words "foods" in it
        boolean condition = i.contains(face);

        if (condition == false){
          // when visibleArray[0] no longer contains "foods" meaning "condition" is false
          // "completed" will subtract one; this number varies everytime therefore "completed" is
          // example:
          // a 4x4 grid will always set completed to 16 until the 15 indexes(0-15) no longer contain "foods"
          completed = completed - 1;
        }
      }

      // break the while loop
      if (completed==0){
        out.println(grid);
        out.println("\nCONGRADULATIONS, YOU HAVE FINISHED THE GAME!!!!\n");
        break;
      }

      // first selection on grid:
      out.println(grid);
      Scanner scanIn = new Scanner(System.in);
      out.print("\nSelect one of the squares based on number.\nEnter '777' to quit at anytime.\nSelected Square: ");
      selectedSquare1 = scanIn.nextInt();
      if (selectedSquare1 == 777){
        out.println("\nTHANK YOU FOR PLAYING.....\n");
        break;
      }

      // redfines grid by showing first selection:
      grid = redefineGrid(selectedSquare1, visibleArray, size);
      out.println(grid);
      // prompts for another selection:
      out.print("\nSelect one of the squares based on number.\nEnter '777' to quit at anytime.\nSelected Square: ");
      selectedSquare2 = scanIn.nextInt();
      if (selectedSquare2 == 777){
        out.println("\nTHANK YOU FOR PLAYING.....\n");
        break;
      }

      // if both selections are the same, redefine grid so they both remain:
      if (visibleArray[1][selectedSquare2] == visibleArray[0][selectedSquare1]){
        grid = redefineGrid(selectedSquare2, visibleArray, size);
      }
      // if selections are not the same then...
      else{
        // allows player to see wrong answer:
        grid = redefineGrid(selectedSquare2, visibleArray, size);
        out.println(grid);
        out.println("\nSORRY THAT WAS NOT A MATCH!\n");

        // starts timer for player to review answer
        startTimer(difficulty);
        // reverts back to previous progress:
        grid = redefineGrid(selectedSquare2, visibleArray, size);
        grid = redefineGrid(selectedSquare1, visibleArray, size);
      }

    } // end of while

  } // end of grid

  static String redefineGrid(int index, String[][] visibleArray, int size){
    String grid = "";
    // temp should contain "foods"
    String temp = visibleArray[0][index];
    // switch the desired index with value that is an actual food like "Apple" which
    // is located in visibleArray[1]
    visibleArray[0][index] = visibleArray[1][index];
    // switches the face("foods") value with true word(ex. "Apple") value:
    visibleArray[1][index] = temp;

    if (size==4){
      grid = grid4x4(visibleArray);
    }
    else if (size==6){
      grid = grid6x6(visibleArray);
    }
    else if (size==8){
      grid = grid8x8(visibleArray);
    }

    return grid;

  }

  // reverts grid to original progress:
  static String redefineGrid(String[][] visibleArray, int size){
    String grid = "";

    if (size==4){
      grid = grid4x4(visibleArray);
    }
    else if (size==6){
      grid = grid6x6(visibleArray);
    }
    else if (size==8){
      grid = grid8x8(visibleArray);
    }

    return grid;
  }


} // end gridGamePlay
