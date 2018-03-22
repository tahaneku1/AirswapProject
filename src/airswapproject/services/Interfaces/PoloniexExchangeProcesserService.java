/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airswapproject.services.Interfaces;

import airswapproject.model.CryptoCurrencyData;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

/**
 *
 * @author Timothy
 */
public interface PoloniexExchangeProcesserService {
    public void displayMovingAverages(String cryptocurrency1,String cryptocurrency2);
    public void setNumberOfSecondsForMovingAverage(long numberOfMinutesForMovingAverage);
    public List<CryptoCurrencyData> getDataFromExchange(String cryptocurrency1, String cryptocurrency2)throws MalformedURLException, IOException;
}
