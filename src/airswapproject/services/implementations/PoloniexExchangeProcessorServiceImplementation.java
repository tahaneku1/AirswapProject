/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airswapproject.services.implementations;

import airswapproject.model.CryptoCurrencyData;
import airswapproject.services.Interfaces.PoloniexExchangeProcesserService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;

//Testing changes 
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import static jdk.nashorn.internal.objects.NativeArray.map;

/**
 *
 * @author Timothy

 */


public class PoloniexExchangeProcessorServiceImplementation implements PoloniexExchangeProcesserService {

    private ObjectMapper mapper = new ObjectMapper();
    private Map<String, CryptoCurrencyData> currencyMap = new HashMap<String, CryptoCurrencyData>();
    private long numberOfSecondsForMovingAverage;
    private double sumOfPricesForCurrency1 = 0;
    private double sumOfPricesForCurrency2 = 0;
    private double numberOfPrices = 0;
    public long getNumberOfSecondsForMovingAverage() {
        return numberOfSecondsForMovingAverage;
    }

    public void setNumberOfSecondsForMovingAverage(long numberOfMinutesForMovingAverage) {
        this.numberOfSecondsForMovingAverage = numberOfMinutesForMovingAverage*60*1000;
    }

    @Override/* I would normally make the params a list of strings for scalability
            but for ease of development, I just put two params because we only want a pair of cryptos*/
    public void displayMovingAverages(String cryptocurrency1, String cryptocurrency2) {  
        List<CryptoCurrencyData> cryptoCurrencyData = null;
        long startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime <= numberOfSecondsForMovingAverage){
                try {
                    cryptoCurrencyData = getDataFromExchange(cryptocurrency1,cryptocurrency2);
                    numberOfPrices++;
                    sumOfPricesForCurrency1+=Double.parseDouble(cryptoCurrencyData.get(0).getLast());
                    sumOfPricesForCurrency2+=Double.parseDouble(cryptoCurrencyData.get(1).getLast());
                } catch (IOException ex) {
                    Logger.getLogger(PoloniexExchangeProcessorServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
                }
            
    }
        System.out.println(cryptocurrency1 + "'s  1 minute moving price is  " + sumOfPricesForCurrency1/numberOfPrices);
        System.out.println(cryptocurrency2 + "'s  1 minute moving price is  " + sumOfPricesForCurrency2/numberOfPrices);
    }
    @Override
    public List<CryptoCurrencyData> getDataFromExchange(String cryptocurrency1, String cryptocurrency2) throws MalformedURLException, IOException{
                URL obj = new URL("https://poloniex.com/public?command=returnTicker");
		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		connection.setRequestMethod("GET");
		int responseCode = connection.getResponseCode();
                List<CryptoCurrencyData> results = new ArrayList<>();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
                    processData(connection);
		} else {
			System.out.println("GET request not worked");
		}
                if(currencyMap.get(cryptocurrency1)==null ||currencyMap.get(cryptocurrency2)==null){
                    try {
                        throw new Exception("Invalid currency : Please provide valid currencies");
                    } catch (Exception ex) {
                        Logger.getLogger(PoloniexExchangeProcessorServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                results.add(currencyMap.get(cryptocurrency1));
                results.add(currencyMap.get(cryptocurrency2));
                
                return results;
    }


    private void processData(HttpURLConnection connection) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(
	connection.getInputStream()));
	String inputLine;
	while ((inputLine = input.readLine()) != null) {
                currencyMap = mapper.readValue(inputLine, new TypeReference<Map<String,CryptoCurrencyData>>(){});
	}
	input.close();
    } 
}
