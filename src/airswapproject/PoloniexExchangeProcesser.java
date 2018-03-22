/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airswapproject;

import airswapproject.services.Interfaces.PoloniexExchangeProcesserService;
import airswapproject.services.implementations.PoloniexExchangeProcessorServiceImplementation;
import java.util.Scanner;

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
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first Cryptocurrency ");
        String currency1 = input.next();
        System.out.println("Enter the second Cryptocurrency ");
        String currency2 = input.next();
        System.out.println("Enter the number of minutes for moving average");
        int numberOfMinutesForMovingAverage = input.nextInt();
        poloniexExchangeProcessorService.setNumberOfSecondsForMovingAverage(1);
        String stoppingInput = "";
        while(!stoppingInput.equalsIgnoreCase("stop")){
            System.out.println("Retreiving 1 minute averages...");
            poloniexExchangeProcessorService.displayMovingAverages(currency1,currency2);
            System.out.println("Enter any character key to continue polling or  'Stop' to stop polling");
            stoppingInput = input.hasNext()? input.next() : "";
        }
       
    }
    
    
    
}
