package twitterStuff;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPort;

import winterwell.jtwitter.OAuthSignpostClient;
import winterwell.jtwitter.Twitter;

public class Main {

	
	static String consumerKey = "h2uWk7fgPgQ3MynvchEg";
	static String consumerSecret = "44GkMpRE2XcMsDPbla5GxVDGbCYmvNOqfedkwKHyc7w";
	static String accessToken = "1938581365-E263zeV3UhB8iCvDX8p5OveQsGgj0GlTPhuqUMf";
	static String accessTokenSecret = "7QAzC9JnVrhqB0v0ds7Oqa2d6fxsw8qxHyKSCD0U";
	
	static OAuthSignpostClient oauthClient = new OAuthSignpostClient(consumerKey, 
			consumerSecret, accessToken,
			accessTokenSecret);
	
	static Twitter twitter = new Twitter("my-name", oauthClient);
	
//	public static void main(String[] args){
//		
//		
//
//		String status = "Testing authorization from our program! -The Humans #HackMIT";
//		System.out.println(status); //print the status
//		twitter.setStatus(status); //set the status
//	}
	
	
	
	
	
	
static String end_result = new String();
	
    public Main()
    {
        super();
    }
    
    void connect ( String portName ) throws Exception
    {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
        if ( portIdentifier.isCurrentlyOwned() )
        {
            System.out.println("Error: Port is currently in use");
        }
        else
        {
            CommPort commPort = portIdentifier.open(this.getClass().getName(),2000);
            
            if ( commPort instanceof SerialPort )
            {
                SerialPort serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(57600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
                
                InputStream in = serialPort.getInputStream();
                OutputStream out = serialPort.getOutputStream();
                               
                (new Thread(new SerialWriter(out))).start();
                
                serialPort.addEventListener(new SerialReader(in));
                serialPort.notifyOnDataAvailable(true);

            }
            else
            {
                System.out.println("Error: Only serial ports are handled by this example.");
            }
        }     
    }
    
    public static void dataAction(){
    	String debug = end_result.replace("\n", "").replace("\r", "");
    	System.out.println(debug);
    	if(debug.length() > 10){
    		//twitter.setStatus(debug);
    	}
    	end_result = "";
    }
    
    /**
     * Handles the input coming from the serial port. A new line character
     * is treated as the end of a block in this example. 
     */
    public static class SerialReader implements SerialPortEventListener 
    {
        private InputStream in;
        private byte[] buffer = new byte[1024];
        
        public SerialReader ( InputStream in )
        {
            this.in = in;
        }
        
        public void serialEvent(SerialPortEvent arg0) {
            int data;
          
            try
            {
                int len = 0;
                while ( ( data = in.read()) > -1 )
                {
                    if ( data == '\n' ) {
                    	dataAction();
                        break;
                    }
                    buffer[len++] = (byte) data;
                }
                end_result += new String(buffer,0,len);
                //System.out.print(new String(buffer,0,len));
            }
            catch ( IOException e )
            {
                e.printStackTrace();
                System.exit(-1);
            }             
        }

    }

    /** */
    public static class SerialWriter implements Runnable 
    {
        OutputStream out;
        
        public SerialWriter ( OutputStream out )
        {
            this.out = out;
        }
        
        public void run ()
        {
            try
            {                
                int c = 0;
                while ( ( c = System.in.read()) > -1 )
                {
                    this.out.write(c);
                }                
            }
            catch ( IOException e )
            {
                e.printStackTrace();
                System.exit(-1);
            }            
        }
    }
    

    
    public static void main ( String[] args )
    {
        try
        {
            (new Main()).connect("COM3");
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



	
	
	
	

	
}
