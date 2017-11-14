package com.redoutevant.helloworldfactory;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Factory
 * @author AMV
 */
public class Main {
 
// versão 1
//    public static void main(String[] args) {
//        System.out.println("Hello World!");
//    }
    
// versão 2
//    public static void main(String[] args) {
//        if(args.length > 0) {
//            System.out.println(args[0]);
//        }
//    }
    
// versão 3
    public static void main(String[] args) {
        Display d = new DisplayImpl();
        Mensageiro m = new MensageiroImpl();
        
        d.setMenssagem(m);
        
        try {
            d.render();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
