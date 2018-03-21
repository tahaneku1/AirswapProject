/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airswapproject.services.implementations;

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
import static jdk.nashorn.internal.objects.NativeArray.map;

/**
 *
 * @author Timothy
 */


public class PoloniexExchangeProcessorServiceImplementation implements PoloniexExchangeProcesserService {

    private ObjectMapper mapper = new ObjectMapper();
    private Map<String, Object> currencyMap = new HashMap<String, Object>();
    

    @Override
    public void displayMovingAverages(String cryptocurrency1, String cryptocurrency2) {   
        try {
            getDataFromExchange();
        } catch (IOException ex) {
            Logger.getLogger(PoloniexExchangeProcessorServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void getDataFromExchange() throws MalformedURLException, IOException{
        URL obj = new URL("https://poloniex.com/public?command=returnTicker");
		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		connection.setRequestMethod("GET");
		int responseCode = connection.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
                    processData(connection);
		} else {
			System.out.println("GET request not worked");
		}
        
    }
    
    private void processData(HttpURLConnection connection) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(
	connection.getInputStream()));
	String inputLine;
	StringBuffer response = new StringBuffer();
	while ((inputLine = input.readLine()) != null) {
                response.append(inputLine);
                currencyMap = mapper.readValue(inputLine, new TypeReference<Map<String, Object>>(){});
	}
	input.close();
    } 
}
