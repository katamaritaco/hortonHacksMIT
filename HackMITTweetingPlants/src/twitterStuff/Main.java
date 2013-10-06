package twitterStuff;

import java.io.*;
import java.net.*;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPort;

import winterwell.jtwitter.OAuthSignpostClient;
import winterwell.jtwitter.Twitter;

import tweetSelection.tweetSelect;

import java.util.*;
import java.io.*;

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
	
	static ArrayList<String> usedList = new ArrayList<String>();
	static int tweetCount = 0;
	
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
    
    public static void dataAction() throws IOException{
    	if (tweetCount > 2){
    		usedList.remove(0);
    	}

    	String debug = end_result.replace("\n", "").replace("\r", "");
    	//System.out.println(debug);
    	if(debug.length() > 10){
    		// get-request: heymitch.com/hortontheplant/?phrase=lololololwut
    		
    		//twitter.setStatus(debug);
    	}
    	
    	tweetSelection.tweetSelect datSelection = new tweetSelection.tweetSelect();
    	String usedString = datSelection.selectATweet(usedList);
    	    	
    	end_result = "";
    	
    	
    	System.out.println(usedString);
    	
    	URL url = new URL("http://www.heymitch.com/hortontheplant/?phrase=" + URLEncoder.encode(usedString, "UTF-8"));
	    URLConnection conn = url.openConnection(); 

	    conn.getContent(); 
    	
    	usedList.add(usedString);
    	
    	tweetCount++;
    	System.out.println(tweetCount);
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
            //dataAction();
            //dataAction();

            //dataAction();
            //dataAction();

        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



	
	
	
	

	
}
