package com.redoutevant.helloworldfactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AMV
 */
public class HelloWorldFactory {
    
    private static HelloWorldFactory instance = null;
    private Properties props = null;
    private Mensageiro msg = null;
    private Display disp = null;
    
    //privado factory
    private HelloWorldFactory() {
        props = new Properties();
        
        try {
            props.load(new FileInputStream("src/main/resources/hello.properties"));
            String displayClass = props.getProperty("Display.class");
            String mensageiroClass = props.getProperty("Mensageiro.class");
            msg = (Mensageiro) Class.forName(mensageiroClass).newInstance();
            disp = (Display) Class.forName(displayClass).newInstance();
            
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(HelloWorldFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static {
        instance = new HelloWorldFactory();
    }
    
    public static HelloWorldFactory getInstance() {
        return instance;
    }
    
    public Display getDisplay() {
        return disp;
    }
    
    public Mensageiro getMensageiro() {
        return msg;
    }
}
