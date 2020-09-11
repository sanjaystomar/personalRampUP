package org.personal.rampup.random;

public class MaximumInstructionsDeletion {
    public static void main(String[] args) {
        String s = "RUDRL";
        int [] fp = {0,0};
        int [] ip = {0,0};

        char[] toChar = s.toCharArray();
        for(int i=0; i<toChar.length;i++){
            if(toChar[i]=='U'){
                ip[1]= ip[1]+1;
            } else if(toChar[i]=='D'){
                ip[1]= ip[1]-1;
            } else if(toChar[i]=='L'){
                ip[0]= ip[0]-1;
            } else if(toChar[i]=='R'){
                ip[0]= ip[0]+1;
            }
        }
        int xDiff = ip[0]-fp[0];
        int yDiff = ip[1]-fp[1];
        System.out.println(xDiff);
        System.out.println(yDiff);
        System.out.println(s.length() - (xDiff+yDiff));


    }
}
