import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    public String Firstt;
    public String Lastt;
    public String Firstp;
    public String Lastp;
    public String Firsta;
    public String Lasta;
    public int bool,CheckAiLoop=0 ;
    public Boolean CheckBoolean = false;
    public Boolean SpecialBooleanAi = false;
    public Boolean wildBoolean = false;
    Random rnd = new Random();
    ArrayList<String> card = new ArrayList<String>();
    ArrayList<String> table = new <String> ArrayList();
    ArrayList<String> pcard = new <String> ArrayList();
    ArrayList<String> acard = new <String> ArrayList();

    public Deck(){                                              //deck zone
        
        for(int i=0;i<2;i++){ 
            for(Enum Number: EnumNumber.values()){
                for(Enum Color: EnumColor.values()){
                    card.add(Number.toString()+" "+Color.toString());
                }
            }
        }
        for(int j=0;j<2;j++){
            for(Enum Action: EnumAction.values()){
                for(Enum Color: EnumColor.values()){
                    card.add(Action.toString()+" "+Color.toString());
                }
            }
        }
        for(int k=0;k<8;k++){
            card.add(EnumNewAction.PlusFour.toString()+" ");
        }

        for(int k=0;k<8;k++){
            card.add(EnumWild.Wild.toString()+" ");
        }
        for(int l=0;l<3;l++){
        Collections.shuffle(card);
        }
          
    }
    public void managewild(String text){
        if(text.equals("y")){
            table.add("collor YELLOW");
            this.getTable();
            this.wildBoolean=true;
        }
        else if(text.equals("r")){
            table.add("collor RED");
            this.getTable();
            this.wildBoolean=true;

        }
        else if(text.equals("g")){
            table.add("collor GREEN");
            this.getTable();
            this.wildBoolean=true;

        }
        else if(text.equals("b")){
            table.add("collor BLUE");
            this.getTable();
            this.wildBoolean=true;

        }
    }
    
    public void RandomPlayer(){                                 //random zone
        bool = rnd.nextInt(2);
        this.bool=bool;

    }
    public void Table(){                                        //table zone
        table.add(card.get(0));
        card.remove(0);
    }
    public String getTable(){
        int idxarrfirst=0;
        int idxarrlast=0;
        int size = table.size();
        String text = table.get(size-1);
        for(int i=0;i<text.length() ;i++){
            if(text.charAt(i)==(' ')){
            break;
            }else{
            idxarrfirst +=1;
            }
        }
        char[] cFirst = new char[idxarrfirst];
        for(int j=0;j<text.length() ;j++){
            if(text.charAt(j)==(' ')){
            break;
            }else{
            cFirst[j] = text.charAt(j);
            }
        }
        
        this.Firstt = String.valueOf(cFirst); //gotfirst
        for(int k=text.length();k>1;k--){
            if(text.charAt(k-1)==(' ')){
            break;
            }else{
            idxarrlast +=1;
            }
        }
        char[] cLast = new char[idxarrlast];
        for(int l=0;l<idxarrlast ;l++){
            
            cLast[l] = text.charAt(idxarrfirst+1+l);
            
        }
        this.Lastt= String.valueOf(cLast); //gotlast
        //System.out.println(table.get(size-1));
        return table.get(size-1);
         
    }
    public void UpdateTable(){
        int idxarrfirst=0;
        int idxarrlast=0;
        int size = table.size();
        String text = table.get(size-1);
        for(int i=0;i<text.length() ;i++){
            if(text.charAt(i)==(' ')){
            break;
            }else{
            idxarrfirst +=1;
            }
        }
        char[] cFirst = new char[idxarrfirst];
        for(int j=0;j<text.length() ;j++){
            if(text.charAt(j)==(' ')){
            break;
            }else{
            cFirst[j] = text.charAt(j);
            }
        }
        
        this.Firstt = String.valueOf(cFirst);//gotfirst
        for(int k=text.length();k>1;k--){
            if(text.charAt(k-1)==(' ')){
            break;
            }else{
            idxarrlast +=1;
            }
        }
        char[] cLast = new char[idxarrlast];
        for(int l=0;l<idxarrlast ;l++){
            
            cLast[l] = text.charAt(idxarrfirst+1+l);
            
        }
        this.Lastt= String.valueOf(cLast);//gotlast
    }
    public void Player(){                                   //player zone
        for(int i=0;i<7;i++){
            pcard.add(card.get(0));
            card.remove(0);
        }
    }
    public int CheckCard(){
        return pcard.size();
    }

    public String LookCard(int n){
        return pcard.get(n-1);
    }
    public void DrawCard(){
        pcard.add(card.get(0));
        card.remove(0);
        
    }
    public void PutCard(int n) {
        int size = pcard.size();
        int idxarrfirst=0;
        int idxarrlast=0;
        String text = pcard.get(n-1);
        for(int i=0;i<text.length() ;i++){
            if(text.charAt(i)==(' ')){
            break;
            }else{
            idxarrfirst +=1;
            
            }
        }
        char[] cFirst = new char[idxarrfirst];
        for(int j=0;j<text.length() ;j++){
            if(text.charAt(j)==(' ')){
            break;
            }else{
            cFirst[j] = text.charAt(j);
            }
        }
        this.Firstp = String.valueOf(cFirst);//gotfirst
        for(int k=text.length();k>1;k--){
            if(text.charAt(k-1)==(' ')){
            break;
            }else{
            idxarrlast +=1;
            }
        }
        char[] cLast = new char[idxarrlast];
        for(int l=0;l<idxarrlast ;l++){
            
            cLast[l] = text.charAt(idxarrfirst+1+l);
            
        }
        this.Lastp = String.valueOf(cLast);//gotlast

        if(Firstp.equals("Plustwo")&&Lastp.equals(Lastt)){
            table.add(pcard.get(n-1));
            UpdateTable();
            pcard.remove(n-1);
            DrawCardAi(2);
            this.CheckBoolean=true;
        }
        else if(Firstp.equals("PlusThree")&&Lastp.equals(Lastt)){
            table.add(pcard.get(n-1));
            UpdateTable();
            pcard.remove(n-1);
            DrawCardAi(3);
            this.CheckBoolean=true;

        }
        else if(Firstp.equals("PlusFour")&&Lastp.equals(" ")){
            table.add(pcard.get(n-1));
            UpdateTable();
            pcard.remove(n-1);
            DrawCardAi(4);
            this.CheckBoolean=true;

        }
        else if(Firstp.equals(Firstt) || Lastp.equals(Lastt)||Firstp.equals("Wild")|| Firstt.equals("Wild") ){
            table.add(pcard.get(n-1));
            UpdateTable();
            pcard.remove(n-1);
            this.CheckBoolean=true;
        }
        else{
            this.CheckBoolean=false;
        }
    }
    
    public void Ai(){                                       //Aizone
        for(int i=0;i<7;i++){
            acard.add(card.get(0));
            card.remove(0);
        }
    }
    public int CheckCardAi(){
        return acard.size();
    }
    public void InputcardAi(){

        for (int z=0;z<10;z++){
        for(int n=0;n<acard.size();n++){
            int size = pcard.size();
        int idxarrfirst=0;
        int idxarrlast=0;
        String text = acard.get(n);

        for(int i=0;i<text.length() ;i++){
            if(text.charAt(i)==(' ')){
            break;
            }else{
            idxarrfirst +=1;
            
            }
        }
        char[] cFirst = new char[idxarrfirst];
        for(int j=0;j<text.length() ;j++){
            if(text.charAt(j)==(' ')){
            break;
            }else{
            cFirst[j] = text.charAt(j);
            }
        }
        this.Firsta = String.valueOf(cFirst);//gotfirst
        for(int k=text.length();k>1;k--){
            if(text.charAt(k-1)==(' ')){
            break;
            }else{
            idxarrlast +=1;
            }
        }
        char[] cLast = new char[idxarrlast];
        for(int l=0;l<idxarrlast ;l++){
            
            cLast[l] = text.charAt(idxarrfirst+1+l);
        }
        this.Lasta = String.valueOf(cLast);//gotlast

        if(Firsta.equals("Plustwo")&&Lasta.equals(Lastt)){
            table.add(acard.get(n));
            
            System.out.println(acard.get(n));
            UpdateTable();
            acard.remove(n);
            for(int atw=0;atw<2;atw++){
                DrawCard();
            }
            this.SpecialBooleanAi=true;
            
        }
        else if(Firsta.equals("PlusThree")&&Lasta.equals(Lastt)){
            table.add(acard.get(n));
            System.out.println(acard.get(n));
            UpdateTable();
            acard.remove(n);
            for(int att=0;att<3;att++){
                DrawCard();
            }
            this.SpecialBooleanAi=true;
        }
        else if(Firsta.equals("PlusFour")&&Lasta.equals(" ")){
            table.add(acard.get(n));
            System.out.println(acard.get(n));
            UpdateTable();
            acard.remove(n);
            for(int atf=0;atf<4;atf++){
                DrawCard();
            }
            this.SpecialBooleanAi=true;
        }  
        else if(Firsta.equals(Firstt) || Lasta.equals(Lastt)||Fi
        rsta.equals("Wild")|| Firstt.equals("Wild")){
            table.add(acard.get(n));
            this.SpecialBooleanAi=true;
            System.out.println(acard.get(n));
            acard.remove(n);
            UpdateTable();    
        }
        }
    }
    CheckAiLoop+=1;
        if(SpecialBooleanAi){
            this.CheckBoolean=true;
            CheckAiLoop=0;

         } else if(CheckAiLoop==2){
            this.CheckBoolean=true;
            CheckAiLoop=0;

            }
        else{
        this.CheckBoolean=false;
        }
        }
        public void DrawCardAi(int n){
            for (int i=0;i<n;i++){
            acard.add(card.get(0));
            card.remove(0);
            }
    } 
    
}
