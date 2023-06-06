import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.synth.SynthSplitPaneUI;
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Deck deck = new Deck();     //create deck
        deck.Table();       //create deck
        deck.Player();      //create deck of player
        deck.Ai();      //create deck of semiAI
        deck.RandomPlayer();        //random who is the first player
        System.out.println(deck.bool);      //show the first player
        String Winner=null;
        Boolean closeloop=false;
        String pickcollor;

        for(int i=0;i>=0;i++){       
            if(deck.bool==1){       //if plyer got play before
                for(int j=0;j<=1;j++){      
                String ainput;
                
              
                System.out.println("Your turn");
               
                System.out.println("You have "+deck.CheckCard()+" Card");
                
                System.out.println( deck.getTable());    
                System.out.println("[L]ook Card");
                System.out.println("[D]raw Card");
                System.out.println("[P]ut Card ");
                System.out.println("[E]nd turn");
                System.out.print("What do you want : ");
                ainput = scn.next();

                
                if(ainput.equals("L")||ainput.equals("l")){
                    System.out.print("What number Card to look : ");
                    int numberlook = scn.nextInt();
                    System.out.println(deck.LookCard(numberlook));
                      
                }
                else if(ainput.equals("p")||ainput.equals("P")){
                    System.out.print("What number Card to put : ");
                    int numberput = scn.nextInt();
                    deck.PutCard(numberput);
                    int size = deck.CheckCard();
                    
                    
                    if(size==0){
                        Winner = "you";
                    deck.bool=3;
                    break;
                    }
                   
                    else if(deck.Firstt.equals("Wild")){
                        System.out.println("[y]ellow");
                        System.out.println("[R]ed");
                        System.out.println("[B]lue");
                        System.out.println("[G]reen");
                        System.out.print("what would you do :");
                        pickcollor = scn.next();
                        deck.managewild(pickcollor);
                        deck.bool=0;
                        closeloop = false;
                    deck.CheckBoolean=false;
                        break;
                        
                    }
                    else if(deck.CheckBoolean){
                        closeloop = true;
                    }
                    
                    else{
                        System.out.println("Your Card mismatch in table");
                    }
               } 
                else if(ainput.equals("d")||ainput.equals("D")){
                    deck.DrawCard();
                    closeloop = true;

                }
                
                else if((ainput.equals("e")&& closeloop)||deck.wildBoolean){
                    deck.bool=0;
                    closeloop = false;
                    deck.CheckBoolean=false;
                    break;
                }
                else{
                    System.out.println("Please draw/put card");
                }
            }
            }else if(deck.bool==0){
                System.out.println("AI turn");
                System.out.println(deck.getTable());
                deck.CheckBoolean=false;
                for(int loopai = 0;loopai>=0;loopai++){
                deck.InputcardAi();
                if(deck.CheckBoolean){
                closeloop = true;
                break;
                }else{
                    deck.DrawCardAi(1);
                }  
            }
                System.out.println("AI have "+deck.CheckCardAi()+" Card");
                int sizeAI = deck.CheckCardAi();
                if(sizeAI==0){
                    deck.bool=3;
                }
                closeloop = false;
                deck.CheckBoolean=false;
                deck.SpecialBooleanAi=false;
                deck.bool=1;
        }
                else if(deck.bool==3){
                if(Winner.equals("you")){
                    System.out.println(Winner+" is win");
                    break;
                }else{
                    System.out.println("AI is win");
                    break;
                } 
            }     
        }
    }   
}
