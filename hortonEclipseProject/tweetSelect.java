import java.util.*;
import java.io.*;

public class tweetSelect {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		ArrayList<String> weatherGood = new ArrayList<String>();
		ArrayList<String> weatherBad = new ArrayList<String>();
		ArrayList<String> temperatureGood = new ArrayList<String>();
		ArrayList<String> temperatureBad = new ArrayList<String>();
		ArrayList<String> humidityGood = new ArrayList<String>();
		ArrayList<String> humidityBad = new ArrayList<String>();
		ArrayList<String> tiltGood = new ArrayList<String>();
		ArrayList<String> tiltBad = new ArrayList<String>();
		ArrayList<String> lightGood = new ArrayList<String>();
		ArrayList<String> lightBad = new ArrayList<String>();
		ArrayList<String> soundGood = new ArrayList<String>();
		ArrayList<String> soundBad = new ArrayList<String>();
		ArrayList<String> miscGood = new ArrayList<String>();
		ArrayList<String> miscBad = new ArrayList<String>();
		ArrayList<String> moistureGood = new ArrayList<String>();
		ArrayList<String> moistureBad = new ArrayList<String>();

		
		//Read in the file
		//BufferedReader reader = new BufferedReader(new FileReader("PlantTweets.txt"));
		BufferedReader reader = new BufferedReader(new FileReader("PlantTweetsSheet.tsv"));
		String line = null;
		while ((line = reader.readLine()) != null) {
			
			//=======================================================================================\\

		///// WEATHER ///// WEATHER ///// WEATHER ///// WEATHER ///// WEATHER ///// WEATHER 
			if(line.contains("WeatherGood")){
				weatherGood.add(line);
			}
			if(line.contains("WeatherBad")){
				weatherBad.add(line);
			}
		///// WEATHER ///// WEATHER ///// WEATHER ///// WEATHER ///// WEATHER ///// WEATHER
			
			//=======================================================================================\\

		///// Temperature ///// Temperature ///// Temperature ///// Temperature ///// Temperature 
			if(line.contains("TemperatureGood")){
				temperatureGood.add(line);
			}
			if(line.contains("TemperatureBad")){
				temperatureBad.add(line);
			}
		///// Temperature ///// Temperature ///// Temperature ///// Temperature ///// Temperature 
			
			//=======================================================================================\\

		///// Humidity ///// Humidity ///// Humidity ///// Humidity ///// Humidity ///// Humidity 
			if(line.contains("HumidityGood")){
				humidityGood.add(line);
			}
			if(line.contains("HumidityBad")){
				humidityBad.add(line);
			}
		///// Humidity ///// Humidity ///// Humidity ///// Humidity ///// Humidity ///// Humidity 
			
			//=======================================================================================\\

		///// Tilt ///// Tilt ///// Tilt ///// Tilt ///// Tilt ///// Tilt ///// Tilt ///// Tilt 
			if(line.contains("TiltGood")){
				tiltGood.add(line);
			}
			if(line.contains("TiltBad")){
				tiltBad.add(line);
			}
		///// Tilt ///// Tilt ///// Tilt ///// Tilt ///// Tilt ///// Tilt ///// Tilt ///// Tilt 
			
		//=======================================================================================\\
	
		///// Light ///// Light ///// Light ///// Light ///// Light ///// Light ///// Light ///// Light 
			if(line.contains("LightGood")){
				lightGood.add(line);
			}
			if(line.contains("LightBad")){
				lightBad.add(line);
			}
		///// Light ///// Light ///// Light ///// Light ///// Light ///// Light ///// Light ///// Light 
		//=======================================================================================\\
		///// Sound ///// Sound ///// Sound ///// Sound ///// Sound ///// Sound ///// Sound 
			if(line.contains("SoundGood")){
				soundGood.add(line);
			}
			if(line.contains("SoundBad")){
				soundBad.add(line);
			}
		///// Sound ///// Sound ///// Sound ///// Sound ///// Sound ///// Sound ///// Sound 
		//=======================================================================================\\
		///// Misc ///// Misc ///// Misc ///// Misc ///// Misc ///// Misc ///// Misc ///// Misc 
			if(line.contains("MiscGood")){
				miscGood.add(line);
			}
			if(line.contains("MiscGood")){
				miscBad.add(line);
			}
		///// Misc ///// Misc ///// Misc ///// Misc ///// Misc ///// Misc ///// Misc ///// Misc 
		//=======================================================================================\\
		///// Moisture ///// Moisture ///// Moisture ///// Moisture ///// Moisture ///// Moisture 
			if(line.contains("MoistureGood")){
				moistureGood.add(line);
			}
			if(line.contains("MoistureBad")){
				moistureBad.add(line);
			}
		///// Moisture ///// Moisture ///// Moisture ///// Moisture ///// Moisture ///// Moisture 
			

		    //System.out.println(line);
		}
		//For each \n, create a new list with name of first element in the array.
		
		//GRAB DATA (WITH KNOWN THRESHOLDS)
		
		//Analyze data (check thresholds)
		
		//Check all boolean thresholds
		//Add appropriate list to master list
		
		//randomly select from master list
		
		//send tweet.
		
		System.out.println(weatherGood.toString());
		System.out.println(weatherGood.toString());
		System.out.println(temperatureGood.toString());
		System.out.println(temperatureBad.toString());
		System.out.println(humidityGood.toString());
		System.out.println(humidityBad.toString());
		System.out.println(tiltGood.toString());
		System.out.println(tiltBad.toString());
		System.out.println(lightGood.toString());
		System.out.println(lightBad.toString());
		System.out.println(soundGood.toString());
		System.out.println(soundBad.toString());
		System.out.println(miscGood.toString());
		System.out.println(miscBad.toString());
		System.out.println(moistureGood.toString());
		System.out.println(moistureBad.toString());

		
		//Scanner scan = new Scanner(System.in);
		
		
		
		
	}

}
