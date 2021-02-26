 import javax.swing.JOptionPane;
 import java.io.*;
 import java.util.Scanner;
 
 class deckInfo {
String Name;
double length;
double width;
double cost;
}

class Main {
  public static void main(String[] args) {

    Scanner fileScanner = null;
    String fileName = "Decks.csv";

   

    int numberInArray = 6;

    deckInfo[] decks = new deckInfo [numberInArray];

    int Index = 0;

    try {
      fileScanner = new Scanner (new BufferedReader (new FileReader (fileName)));
      fileScanner.useDelimiter("[\\r\\n,]+");
      while (fileScanner.hasNext()) {
         decks[Index] = new deckInfo();
         decks[Index].Name = fileScanner.next();
         decks[Index].length = fileScanner.nextDouble();
         decks[Index].width = fileScanner.nextDouble();
         decks[Index].cost = fileScanner.nextDouble();
         Index = Index + 1;
      }
      }
  catch (FileNotFoundException error) {
    System.out.println("File not found, fix the code an try again");
  } finally {
    if(fileScanner!=null) {
      fileScanner.close();
    }
  }
  int Choice = 0;
while(Choice != 4){
  Choice = Keyboard.getInt("enter Choice");
//the 
  while(Choice < 1 || Choice >4) {
      System.out.println("this is an invalid choice");
      Choice = Keyboard.getInt("enter Choice");
  }
  
    
    
      if(Choice == 1){
        String cheapestName;
        double cheapestDeck = 0;
        for(int index = 0; index < decks.length; index ++){
          if(decks[index].cost > cheapestDeck){
            cheapestName = decks[index].Name;
            
          }
        }
System.out.println("the cheapest deck is " + cheapestDeck);


      }
      else if(Choice == 2){
        String otherOptions = "";
        double chosenLength = Keyboard.getInt("enter length");
        for(int index = 0; index < decks.length; index ++){
          if(decks[index].length >= chosenLength){
            otherOptions = otherOptions + "\n" + decks[index].Name;
          
            
          }
        }
        System.out.println("your other options are " + otherOptions);
       
      }
      else if(Choice == 3){
        int otherOptions = 0;
        int choosenArea = Keyboard.getInt("enter your choosen area ");
        for(int index = 0; index < decks.length; index ++){
          if(decks[index].length*decks[index].width >= choosenArea){
            otherOptions = otherOptions + 1;
            
            
          }
        }
        System.out.println("the amount of other options are " + otherOptions);
      }
    }
    
  }
}