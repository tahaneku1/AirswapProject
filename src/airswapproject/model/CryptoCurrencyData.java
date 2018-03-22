/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airswapproject.model;

/**
 *
 * @author Timothy
 *  * {"id":7,"last":"0.00000030","lowestAsk":"0.00000031","highestBid":"0.00000030",
 * "percentChange":"-0.03225806","baseVolume":"21.63169869","quoteVolume":"69478751.24923322",
 * "isFrozen":"0","high24hr":"0.00000032","low24hr":"0.00000030"}
 */
public class CryptoCurrencyData {
    private String id;
    private String last;
    private String lowestAsk;
    private String highestBid;
    private String percentChange;
    private String baseVolume;
    private String quoteVolume;
    private String isFrozen;
    private String high24hr;
    private String low24hr;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getLowestAsk() {
        return lowestAsk;
    }

    public void setLowestAsk(String lowestAsk) {
        this.lowestAsk = lowestAsk;
    }

    public String getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(String highestBid) {
        this.highestBid = highestBid;
    }

    public String getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(String percentChange) {
        this.percentChange = percentChange;
    }

    public String getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(String baseVolume) {
        this.baseVolume = baseVolume;
    }

    public String getQuoteVolume() {
        return quoteVolume;
    }

    public void setQuoteVolume(String quoteVolume) {
        this.quoteVolume = quoteVolume;
    }

    public String getIsFrozen() {
        return isFrozen;
    }

    public void setIsFrozen(String isFrozen) {
        this.isFrozen = isFrozen;
    }

    public String getHigh24hr() {
        return high24hr;
    }

    public void setHigh24hr(String high24hr) {
        this.high24hr = high24hr;
    }

    public String getLow24hr() {
        return low24hr;
    }

    public void setLow24hr(String low24hr) {
        this.low24hr = low24hr;
    }
    
    
}
