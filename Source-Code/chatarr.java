import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// This is a tool to make an Ai chatbot give out a list for big data sets. Ai tends to forget instructions or not read 
// a document due to pre-training bias, this tool keeps track of the ai's answers and keeps it focused.
// example: "List all spells of the book "harry potter" in this pdf. An ai will have been trained on harry p., so rather then read
// it, the ai will just give you the spells, even if you added some spells into the book yourself, which it will not list. 
// This tool prevents that :) Author: Toasti, Inspiration: Tiktok on the described Harry p. situation
public class chatarr{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean EOF = false;
        boolean isFirstRun = true;
        boolean isCorrectStepAmmount = true;
        int startIdx =-5;

        IO.print("Enter the prompt: ");
        String prompt = scanner.nextLine();

        IO.print("Enter the page step ammount: ");
        int step = 5;
        try {
            step = scanner.nextInt();
        } catch (Exception e){
            isCorrectStepAmmount = false;
        }

        int endIdx =  step;


        ArrayList<String> persistentMemBlock = new ArrayList<>();
        while (!EOF){
            try{
                if (!isCorrectStepAmmount){
                    IO.println("### Note ###\nThat was not a (whole) number. Using default of 5\n");

                }
                String currentPrompt = prompt;
                IO.print("Enter Chat Input: "); 
                String response = scanner.nextLine();
                ArrayList<String> memBlock = new ArrayList<>(Arrays.asList(response.split(" ")));

                if (memBlock.contains("EOF")){
                    IO.println("=== EOF ===");
                    EOF = true;
                }
                if(!isFirstRun){
                startIdx += step;
                endIdx += step;
                } else {
                    startIdx += 5;
                    isFirstRun = false;
                }

                currentPrompt = currentPrompt + " Read the provided document from page " + startIdx + " to " + endIdx + ". Use only the document as a source, no online research. Give out a list of words corresponding to earlier instructions seperated by a space. If there are no more pages left in the document, write 'EOF'.";



                
                for (String word : memBlock){
                    persistentMemBlock.add(word);
                }

                clearScreen();
                IO.println("\n\n" + currentPrompt + "\n\n");




            } catch (Exception e){;}

        }


        IO.print("Remove dublicates? (y/n): ");
        String deleteRedundancy = scanner.nextLine();
        ArrayList<String> newList = new ArrayList<>();

        if(deleteRedundancy.equals("y")){
           for (String element : persistentMemBlock) {
                if (!newList.contains(element)) {
                    newList.add(element);
                }
            }     
            persistentMemBlock = newList; 

        } else {
            newList = persistentMemBlock;
        }

        IO.print("Sanitize List? (y/n): ");
        String sanetizeInput = scanner.nextLine();
        if(sanetizeInput.equals("y")){
            newList.remove(0);
            newList.remove("EOF");
        }



        IO.println(newList);

    }



    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

  
}
