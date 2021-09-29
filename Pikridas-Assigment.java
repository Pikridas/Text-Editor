import java.util.Scanner;

public class Vathmoi {
  
    public static void main (String[] args) {
    int cnt=0;
    double sum=0.0, vathmos=0.0;
    String mathima,am;
    
    /*  
        DINONTAI ODHGIES STON XRISTI
        WSTE NA EINAI SE THESINA XRHSIMOPOIHSEI
        SWSTA TO PROGRAMMA
    */
    System.out.printf("------------------------------------------------------------\n");
    System.out.printf("ODHGIES PROGRAMMATOS\n");
    System.out.printf("DWSE MOU AM FOITHTH\n");
    System.out.printf("OTAN TELEIWSEIS ME TON FOITITI DWSE 000000\n");
    System.out.printf("OTAN DWSEIS VATHMOUS STA ANTISTOIXA MATHIMATA DWSE END\n");
    System.out.printf("TELOS ODHGIWN PROGRAMMATOS\n");
    System.out.printf("------------------------------------------------------------\n");
    
    /*
    KLASI H OPOIA MOU EPITREPEI
    NA DIAVAZW TIMES APO TO PLIKTROLOGIO
    */
    Scanner input=new Scanner(System.in);
      
    /*
    DIAVASMA AM FOITHTH
    */
    System.out.printf("\nDWSE MOU AM FOITHTH\n");
    am=input.next();
    
    /*
    OSO TO AM EINAI DIAFORO TOU "000000"
    TOTE O XRISTIS DINEI ONOMATA MATHIMATWN
    KAI VATHMOUS STA ANTISTOIXA MATHIMATA.
    OTAN O XRISTIS DWSEI WS TITLO MATHIMATOS TO "END"
    TOTE EMANIZETAI O MESOS OROS MATHIMATWN TOY FOITHTH. 
    */

    while( !am.equals("000000")) {
        System.out.printf("DWSE MOU ONOMA MATHIMATOS\n");
        mathima = input.next();
    
        while( !mathima.equals("END")) {
            System.out.printf("DWSE MOU VATHMO GIA TO MATHIMA ME TITLO %s\n",mathima);
            vathmos = input.nextDouble();
            sum += vathmos;
            cnt++;
            System.out.printf("O %s STO MATHIMA ME TITLO %s EXEI VATHMO:%.1f\n",am,mathima,vathmos);
            System.out.printf("DWSE MOU ONOMA MATHIMATOS\n");
            mathima = input.next();
 }
    System.out.printf("\nO MESOS OROS MATHIMATWN TOU FOITITI ME AM %s EINAI:%.1f\n",am,sum/cnt);
    sum=0;
    cnt=0;
    System.out.printf("DWSE MOU AM FOITHTH\n");
    am = input.next();
}
}
}
