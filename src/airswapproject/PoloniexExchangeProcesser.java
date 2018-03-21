/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airswapproject;

import airswapproject.services.Interfaces.PoloniexExchangeProcesserService;
import airswapproject.services.implementations.PoloniexExchangeProcessorServiceImplementation;

/**
 *
 * @author Timothy
 */
public class PoloniexExchangeProcesser {

    /**
     * @param args the command line arguments
     */
    private static PoloniexExchangeProcesserService poloniexExchangeProcessorService
    = new PoloniexExchangeProcessorServiceImplementation();
    
    public static void main(String[] args) {
        // TODO code application logic here
        poloniexExchangeProcessorService.displayMovingAverages("", "");
    }
    
    
    
}
