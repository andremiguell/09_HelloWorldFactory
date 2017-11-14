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
    private HelloWorldFactory() throws IOException {
        props = new Properties();
        
        try {
            props.load(new FileInputStream("src/main/resources/hello.properties"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HelloWorldFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
