import java.util.Scanner;

public class Spiel {
    char[][]feld = new char[3][3];
    private int spieler = 2;
    private int runden = 0;
    private boolean stimmt = false;
    private boolean alleine = false;
    
    public Spiel (int spieler, int runden){
        Scanner S1 = new Scanner(System.in);
            System.out.println("Spielst du alleine? (ja/nein)");
            String antwort = S1.nextLine();
            if(antwort.equals("ja")){
                alleine = true;
            }
        this.spieler = spieler;
        this.runden = runden;
        for(int x = 0; x < feld.length ; x++){
            for (int y = 0; y < feld.length ; y++){
                feld[x][y]= '?';
            }
        }
    }
    public void Ausgabe(){
        System.out.println(feld[0][0] + " | " + feld[1][0] + " | " + feld[2][0]);
        System.out.println(feld[0][1] + " | " + feld[1][1] + " | " + feld[2][1]);
        System.out.println(feld[0][2] + " | " + feld[1][2] + " | " + feld[2][2]);
    } 
    public void play(){
        spieler = 1;
        runden = 0 ;
        stimmt =  false;
        
        Scanner s = new Scanner (System.in);
            while( gewonnen() == 0 && runden < 9){
                System.out.println("Spieler" + spieler+", du bist dran");
                do {
                    System.out.println("Reihe?");
                    int reihe = Integer.parseInt(s.nextLine());
                    if(reihe < 0 || reihe > 2){
                        System.out.println("Bitte eine Zahl zwischen 0 und 2 eingeben");
                    }
                    System.out.println("spalte?");
                    int spalte = Integer.parseInt(s.nextLine());
                    if(reihe < 0 || reihe > 2){
                        System.out.println("Bitte eine Zahl zwischen 0 und 2 eingeben");
                    }
                    if(feld[reihe][spalte] != '?'){
                        System.out.println("Dieses Feld ist schon belegt");
                    }
                    else if(feld[reihe][spalte] == '?'){
                        if(spieler == 1){
                            feld[reihe][spalte]='o';    
                            if(alleine == false){
                                spieler = 2;
                            }
                            else{
                                spieler = 3;
                            }
                        }
                        else {
                            feld[reihe][spalte] = 'x';
                            spieler = 1;
                        }
                         Ausgabe();
                        runden++;
                        stimmt = true;
                        break;
                    }
                }
                while(stimmt == false);
                
               
            }
        if (gewonnen() == 1){
             System.out.println("Das Spiel ist zu Ende");
             System.out.println("Spieler 2 hat gewonnen");
        }
        if (gewonnen() == 2){
             System.out.println("Das Spiel ist zu Ende");
             System.out.println("Spieler 1 hat gewonnen");
        }        
    }
    public int gewonnen(){
        if (feld[0][0]== 'x' && feld[0][1] == 'x' && feld[0][2]== 'x' ){
            return 1;
        }
        else if (feld[1][0]== 'x' && feld[1][1] == 'x' && feld[1][2]== 'x' ){
            return 1;
        }
        else if (feld[2][0]== 'x' && feld[2][1] == 'x' && feld[2][2]== 'x' ){
            return 1;
        }
        else if (feld[0][0]== 'x' && feld[1][0] == 'x' && feld[2][0]== 'x' ){
            return 1;
        }
        else if (feld[0][1]== 'x' && feld[1][1] == 'x' && feld[2][1]== 'x' ){
            return 1;
        }
        else if (feld[0][2]== 'x' && feld[1][2] == 'x' && feld[2][2]== 'x' ){
            return 1;
        }
        else if (feld[0][0]== 'x' && feld[1][1] == 'x' && feld[2][2]== 'x' ){
            return 1;
        }
        else if (feld[0][2]== 'x' && feld[1][1] == 'x' && feld[2][0]== 'x' ){
            return 1;
        }

        //Sieg für o

        if (feld[0][0]== 'o' && feld[0][1] == 'o' && feld[0][2]== 'o' ){
            return 2;
        }
        else if (feld[1][0]== 'o' && feld[1][1] == 'o' && feld[1][2]== 'o' ){
            return 2;
        }
        else if (feld[2][0]== 'o' && feld[2][1] == 'x' && feld[2][2]== 'o' ){
            return 2;
        }
        else if (feld[0][0]== 'o' && feld[1][0] == 'o' && feld[2][0]== 'o' ){
            return 2;
        }
        else if (feld[0][1]== 'o' && feld[1][1] == 'o' && feld[2][1]== 'o' ){
            return 2;
        }
        else if (feld[0][2]== 'o' && feld[1][2] == 'o' && feld[2][2]== 'o' ){
            return 2;
        }
         else if (feld[0][0]== 'o' && feld[1][1] == 'o' && feld[2][2]== 'o' ){
            return 2;
        }
        else if (feld[0][2]== 'o' && feld[1][1] == 'o' && feld[2][0]== 'o' ){
            return 2;
        }
        else {
            return 0;
        }
    }
}  