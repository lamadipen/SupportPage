package supportpage.classic.services;

import org.xmlrpc.android.XMLRPCClient;
import org.xmlrpc.android.XMLRPCException;

import java.net.URI;

/**
 * Created by Administrator on 6/21/2016.
 */
public class XmlRpcClientService {

    private XMLRPCClient client;
    private URI uri;
    private String urlString = "http://api.classic.com.np";

    Object test="Startign";

    public void getUserInfo()
    {
        uri = URI.create(urlString);
        client = new XMLRPCClient(uri);

        try {
            test = (Object) client.call("getUserInfo","ctdeveloper");
        } catch (XMLRPCException e) {
            e.printStackTrace();
        }
    }
}
