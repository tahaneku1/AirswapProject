/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Timothy
 */
import airswapproject.model.CryptoCurrencyData;
import airswapproject.services.Interfaces.PoloniexExchangeProcesserService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class PoloniexExchangeProcesserServiceTest {
    
  @Mock
  private PoloniexExchangeProcesserService service;
 
  @Test
    public void getDataFromExchangePositiveTest() {

        String cryptoCurrency1 = "C1";
        String cryptoCurrency2 = "C2";
        
        List<CryptoCurrencyData> cryptoCurrencyDataMockList = new ArrayList<>();
         List<CryptoCurrencyData> actualResponse = null;
        CryptoCurrencyData cryptoCurrencyDataMock1 = new CryptoCurrencyData();
        cryptoCurrencyDataMock1.setId("1");
        cryptoCurrencyDataMock1.setLast("0.1");
        
        CryptoCurrencyData cryptoCurrencyDataMock2 = new CryptoCurrencyData();
        cryptoCurrencyDataMock1.setId("2");
        cryptoCurrencyDataMock1.setLast("0.2");
        
        cryptoCurrencyDataMockList.add(cryptoCurrencyDataMock1);
        cryptoCurrencyDataMockList.add(cryptoCurrencyDataMock2);
        
      try {
          when(service.getDataFromExchange(cryptoCurrency1, cryptoCurrency2))
                  .thenReturn(new ArrayList<>(cryptoCurrencyDataMockList));
          actualResponse = service.getDataFromExchange(cryptoCurrency1, cryptoCurrency2);
      } catch (IOException ex) {
          Logger.getLogger(PoloniexExchangeProcesserServiceTest.class.getName()).log(Level.SEVERE, null, ex);
      }
        assertEquals(actualResponse,cryptoCurrencyDataMockList);
    }
    
      @Test
    public void getDataFromExchangeNegativeTest() {

        String cryptoCurrency1 = "C1";
        String cryptoCurrency2 = "C2";
        
        List<CryptoCurrencyData> cryptoCurrencyDataMockList = new ArrayList<>();
         List<CryptoCurrencyData> actualResponse = null;
        CryptoCurrencyData cryptoCurrencyDataMock1 = new CryptoCurrencyData();
        cryptoCurrencyDataMock1.setId("1");
        cryptoCurrencyDataMock1.setLast("0.1");
        
        CryptoCurrencyData cryptoCurrencyDataMock2 = new CryptoCurrencyData();
        cryptoCurrencyDataMock1.setId("2");
        cryptoCurrencyDataMock1.setLast("0.2");
        
        cryptoCurrencyDataMockList.add(cryptoCurrencyDataMock1);
        cryptoCurrencyDataMockList.add(cryptoCurrencyDataMock2);
        
        
         List<CryptoCurrencyData> fakeCryptoCurrencyDataMockList = new ArrayList<>();
         CryptoCurrencyData fakeCryptoCurrencyDataMock1 = new CryptoCurrencyData();
         fakeCryptoCurrencyDataMock1.setId("3");
         fakeCryptoCurrencyDataMock1.setLast("0.3");
         fakeCryptoCurrencyDataMockList.add(fakeCryptoCurrencyDataMock1);
        
      try {
          when(service.getDataFromExchange(cryptoCurrency1, cryptoCurrency2))
                  .thenReturn(new ArrayList<>(cryptoCurrencyDataMockList));
          actualResponse = service.getDataFromExchange(cryptoCurrency1, cryptoCurrency2);
      } catch (IOException ex) {
          Logger.getLogger(PoloniexExchangeProcesserServiceTest.class.getName()).log(Level.SEVERE, null, ex);
      }
        assertNotSame(actualResponse,fakeCryptoCurrencyDataMockList);
    }

}
