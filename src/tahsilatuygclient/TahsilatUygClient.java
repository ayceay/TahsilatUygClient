/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahsilatuygclient;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.BindingProvider;
import tr.gov.ptt.tahsilatuygclient.clients.AnyTypeArray;
import tr.gov.ptt.tahsilatuygclient.clients.TahsilatBorc;

/**
 *
 * @author Administrator
 */
public class TahsilatUygClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            List<tr.gov.ptt.tahsilatuygclient.clients.TahsilatBorc> liste = chartVerisiGetir();
            for (TahsilatBorc liste1 : liste) {
                System.out.println(liste1.getAboneAd() + " " +liste1.getAboneSoyad()+ " "+liste1.getFaturaNo());
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(TahsilatUygClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static java.util.List<tr.gov.ptt.tahsilatuygclient.clients.TahsilatBorc> chartVerisiGetir() throws MalformedURLException {
        
        
        tr.gov.ptt.tahsilatuygclient.clients.TahsilatBorcWs_Service service = new 
        tr.gov.ptt.tahsilatuygclient.clients.TahsilatBorcWs_Service();
        
        
        
        tr.gov.ptt.tahsilatuygclient.clients.TahsilatBorcWs port = service.getTahsilatBorcWsPort();
        BindingProvider bindingProvider = (BindingProvider) port;
        bindingProvider.getRequestContext().put(
                BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                "http://localhost:8080/GR1TahsilatUyg/TahsilatBorcWs?wsdl");//"http://10.10.10.131:8080/Gr1TahsilatUyg/TahsilatBorcWS?WSDL"
        return port.findAllBorcViaKurumIdAndAboneNo("ASKİ","123456");
    }
    
}
