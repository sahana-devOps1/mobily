import java.util.List;
import java.net.URL;
 
import javax.xml.ws.BindingProvider;
import javax.xml.namespace.QName;
 
public class CreateWebSource
{
  public static void main(String[] args) throws Exception
  {
    System.out.println( "" );
 
    try
    {
      if ( args == null || args.length != 4 )
      {
        System.out.println(
          "Usage:\n  CreateWebSource <webServiceURL> <userName> <password> <webSourceURL>"
        );
      }
      else
      {
        // Get web service URL from command-line arguments
        String webServiceURL = args[0];
        System.out.println( "Using web service URL \"" + webServiceURL + "\"\n" ); 
        
        // Get username and password
        String userName = args[1];
        String password = args[2];
  
        // Get stateless web service client
        AdminPortType adminPort = 
          getStatelessWebServiceClient( webServiceURL );
      
        // Create Credentials object for operations
        Credentials credentials = new Credentials();
        credentials.setUserName( userName );
        credentials.setPassword( password );
 
        // 1. Create a simple web source
        String webSourceURL = args[3];
        String webSourceXML = 
"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
"<search:config productVersion=\"11.1.2.0.0\" xmlns:search=\"http://xmlns.oracle.com/search\">" +
"  <search:sources>" +
"    <search:webSource>" +
"      <search:name>web1</search:name>" +
"        <search:startingUrls>" +
