package controller;

import java.io.InputStreamReader;
import java.io.Reader;

/**
 * User: Vilius Kukanauskas
 * Package: controller
 * Date: 30.09.2015
 * Time: 1:56 PM
 */
public class CSVHelper {

    public static Reader getInputStream(){
        Reader result = new InputStreamReader(PersonController.class.getResourceAsStream("../data/personen.csv"));
        return result;
    }

}
