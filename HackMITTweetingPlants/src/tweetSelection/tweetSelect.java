package tweetSelection;

import java.util.*;
import java.io.*;

import weatherAPIZ.weather;

public class tweetSelect {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public String selectATweet(ArrayList<String> usedList, int light, int sound, String direction, double humidity, double temperature) throws IOException {
		
		ArrayList<String> weatherGood = new ArrayList<String>();
		ArrayList<String> weatherBad = new ArrayList<String>();
		ArrayList<String> temperatureGood = new ArrayList<String>();
		ArrayList<String> temperatureNeutral = new ArrayList<String>();
		ArrayList<String> temperatureBad = new ArrayList<String>();
		ArrayList<String> humidityGood = new ArrayList<String>();
		ArrayList<String> humidityBad = new ArrayList<String>();
		ArrayList<String> tiltBad = new ArrayList<String>();
		ArrayList<String> lightGood = new ArrayList<String>();
		ArrayList<String> lightBad = new ArrayList<String>();
		ArrayList<String> soundGood = new ArrayList<String>();
		ArrayList<String> soundBad = new ArrayList<String>();
		ArrayList<String> miscGood = new ArrayList<String>();
		ArrayList<String> miscBad = new ArrayList<String>();
		ArrayList<String> moistureGood = new ArrayList<String>();
		ArrayList<String> moistureNeutral = new ArrayList<String>();
		ArrayList<String> moistureBad = new ArrayList<String>();

		ArrayList<String> masterList = new ArrayList<String>();
		
		//ArrayList<String> usedList = new ArrayList<String>();

		boolean isWeatherGood = false;//set to false for the time being.
		boolean isHumidityGood = false;//true = high; false = low
		boolean isTiltGood = false;//can only be false
		boolean isLightGood = false;
		boolean isSoundGood = true;
		boolean isMiscGood = false;
		int moistureGoodEnum = 0;//0 = bad, 1 = neutral, 2 = good
		int temperatureGoodEnum = 0;//0 = bad, 1 = neutral, 2 = good

		int totalTweetSize = 0;
		
		//////////////////////////////////////////Start Run threshold calculations
		// light good >= 400
		// light bad < 400
		 
		 //above 800 or below 200 is loud.

		if(light  >= 400){//this is bright!
			isLightGood = true;
		}
		if(sound > 700 || sound < 300){//'loud' values
			
			isSoundGood = false;
		}
		if(temperature < 75 && temperature > 65){
			temperatureGoodEnum = 2;
		}
		else if((temperature < 85 && temperature >= 75) || (temperature <= 65 && temperature > 55)){
			temperatureGoodEnum = 1;
		}
		else{
			temperatureGoodEnum = 0;
		}
		if(humidity > 60){
			isHumidityGood = true;
		}
		
		weatherAPIZ.weather weather= new weatherAPIZ.weather();
		isWeatherGood = weather.isWeatherGood();
		
		///////////////////////////////////////////End Run Threshold Calculations*/
		
		//Read in the file
		//BufferedReader reader = new BufferedReader(new FileReader("PlantTweets.txt"));
		BufferedReader reader = new BufferedReader(new FileReader("PlantTweetsSheet.tsv"));
		String line = null;
		while ((line = reader.readLine()) != null) {
			
			//=======================================================================================\\

		///// WEATHER ///// WEATHER ///// WEATHER ///// WEATHER ///// WEATHER ///// WEATHER 
			if(line.contains("WeatherGood")){
				String[] parts = line.split("\t");
				for (String part : parts) {
					weatherGood.add(part);
					totalTweetSize++;
				}
				totalTweetSize--;
				weatherGood.remove(0);
			}
			if(line.contains("WeatherBad")){
				String[] parts = line.split("\t");
				for (String part : parts) {
					weatherBad.add(part);
					totalTweetSize++;
				}
				totalTweetSize--;
				weatherBad.remove(0);
			}
		///// WEATHER ///// WEATHER ///// WEATHER ///// WEATHER ///// WEATHER ///// WEATHER
			
			//=======================================================================================\\

		///// Temperature ///// Temperature ///// Temperature ///// Temperature ///// Temperature 
			if(line.contains("TemperatureGood")){
				String[] parts = line.split("\t");
				for (String part : parts) {
					temperatureGood.add(part);
					totalTweetSize++;
				}
				totalTweetSize--;
				temperatureGood.remove(0);
			}
			if(line.contains("TemperatureNeutral")){
				String[] parts = line.split("\t");
				for (String part : parts) {
					temperatureNeutral.add(part);
					totalTweetSize++;
				}
				totalTweetSize--;
				temperatureNeutral.remove(0);
			}
			if(line.contains("TemperatureBad")){
				String[] parts = line.split("\t");
				for (String part : parts) {
					temperatureBad.add(part);
					totalTweetSize++;
				}
				totalTweetSize--;
				temperatureBad.remove(0);
			}
		///// Temperature ///// Temperature ///// Temperature ///// Temperature ///// Temperature 
			
			//=======================================================================================\\

		///// Humidity ///// Humidity ///// Humidity ///// Humidity ///// Humidity ///// Humidity 
			if(line.contains("HumidityGood")){
				String[] parts = line.split("\t");
				for (String part : parts) {
					humidityGood.add(part);
					totalTweetSize++;
				}
				totalTweetSize--;
				humidityGood.remove(0);
			}
			if(line.contains("HumidityBad")){
				String[] parts = line.split("\t");
				for (String part : parts) {
					humidityBad.add(part);
					totalTweetSize++;
				}
				totalTweetSize--;
				humidityBad.remove(0);
			}
		///// Humidity ///// Humidity ///// Humidity ///// Humidity ///// Humidity ///// Humidity 
			
			//=======================================================================================\\

		///// Tilt ///// Tilt ///// Tilt ///// Tilt ///// Tilt ///// Tilt ///// Tilt ///// Tilt 
			if(line.contains("TiltBad")){
				String[] parts = line.split("\t");
				for (String part : parts) {
					tiltBad.add(part);
					totalTweetSize++;
				}
				totalTweetSize--;
				tiltBad.remove(0);
			}
		///// Tilt ///// Tilt ///// Tilt ///// Tilt ///// Tilt ///// Tilt ///// Tilt ///// Tilt 
			
		//=======================================================================================\\
	
		///// Light ///// Light ///// Light ///// Light ///// Light ///// Light ///// Light ///// Light 
			if(line.contains("LightGood")){
				String[] parts = line.split("\t");
				for (String part : parts) {
					lightGood.add(part);
					totalTweetSize++;
				}
				totalTweetSize--;
				lightGood.remove(0);
			}
			if(line.contains("LightBad")){
				String[] parts = line.split("\t");
				for (String part : parts) {
					lightBad.add(part);
					totalTweetSize++;
				}
				totalTweetSize--;
				lightBad.remove(0);
			}
		///// Light ///// Light ///// Light ///// Light ///// Light ///// Light ///// Light ///// Light 
		//=======================================================================================\\
		///// Sound ///// Sound ///// Sound ///// Sound ///// Sound ///// Sound ///// Sound 
			if(line.contains("SoundGood")){
				String[] parts = line.split("\t");
				for (String part : parts) {
					soundGood.add(part);
					totalTweetSize++;
				}
				totalTweetSize--;
				soundGood.remove(0);
			}
			if(line.contains("SoundBad")){
				String[] parts = line.split("\t");
				for (String part : parts) {
					soundBad.add(part);
					totalTweetSize++;
				}
				totalTweetSize--;
				soundBad.remove(0);
			}
		///// Sound ///// Sound ///// Sound ///// Sound ///// Sound ///// Sound ///// Sound 
		//=======================================================================================\\
		///// Misc ///// Misc ///// Misc ///// Misc ///// Misc ///// Misc ///// Misc ///// Misc 
			if(line.contains("MiscGood")){
				String[] parts = line.split("\t");
				for (String part : parts) {
					miscGood.add(part);
					totalTweetSize++;
				}
				totalTweetSize--;
				miscGood.remove(0);
			}
			if(line.contains("MiscGood")){
				String[] parts = line.split("\t");
				for (String part : parts) {
					miscBad.add(part);
					totalTweetSize++;
				}
				totalTweetSize--;
				miscBad.remove(0);
			}
		///// Misc ///// Misc ///// Misc ///// Misc ///// Misc ///// Misc ///// Misc ///// Misc 
		//=======================================================================================\\
		///// Moisture ///// Moisture ///// Moisture ///// Moisture ///// Moisture ///// Moisture 
			if(line.contains("MoistureGood")){
				String[] parts = line.split("\t");
				for (String part : parts) {
					moistureGood.add(part);
					totalTweetSize++;
				}
				totalTweetSize--;
				moistureGood.remove(0);
			}
			if(line.contains("MoistureNeutral")){
				String[] parts = line.split("\t");
				for (String part : parts) {
					moistureNeutral.add(part);
					totalTweetSize++;
				}
				totalTweetSize--;
				moistureNeutral.remove(0);
			}
			if(line.contains("MoistureBad")){
				String[] parts = line.split("\t");
				for (String part : parts) {
					moistureBad.add(part);
					totalTweetSize++;
				}
				totalTweetSize--;
				moistureBad.remove(0);
			}
		///// Moisture ///// Moisture ///// Moisture ///// Moisture ///// Moisture ///// Moisture 
			
		}
		//For each \n, create a new list with name of first element in the array.
		
		//GRAB DATA (WITH KNOWN THRESHOLDS)
		
		//Analyze data (check thresholds)
		if(isWeatherGood){
			masterList.addAll(weatherGood);
		}
		else if (!isWeatherGood){
			masterList.addAll(weatherBad);
		}
		if(temperatureGoodEnum == 0){
			masterList.addAll(temperatureBad);
		}
		else if (temperatureGoodEnum == 1){
			masterList.addAll(temperatureNeutral);
		}
		else if (temperatureGoodEnum == 2){
			masterList.addAll(temperatureGood);
		}
		if(isHumidityGood){
			masterList.addAll(humidityGood);
		}
		else if (!isHumidityGood){
			masterList.addAll(humidityBad);
		}
		if(!isTiltGood){
			masterList.addAll(tiltBad);
		}
		if(isLightGood){
			masterList.addAll(lightGood);
		}
		else if (!isLightGood){
			masterList.addAll(lightBad);
		}		
		if(isSoundGood){
			masterList.addAll(soundGood);
		}
		else if (!isSoundGood){
			masterList.addAll(soundBad);
		}		
		if(isMiscGood){
			masterList.addAll(miscGood);
		}
		else if (!isMiscGood){
			masterList.addAll(miscBad);
		}		
		if(moistureGoodEnum == 0){
			masterList.addAll(moistureBad);
		}
		else if (moistureGoodEnum == 1){
			masterList.addAll(moistureNeutral);
		}
		else if (moistureGoodEnum == 2){
			masterList.addAll(moistureGood);
		}
		//Check all boolean thresholds
		//Add appropriate list to master list
		
		//randomly select from master list

		//send tweet.
		
//		System.out.println(weatherGood.toString());
//		System.out.println(weatherBad.toString());
//		System.out.println(temperatureGood.toString());
//		System.out.println(temperatureBad.toString());
//		System.out.println(humidityGood.toString());
//		System.out.println(humidityBad.toString());
//		System.out.println(tiltBad.toString());
//		System.out.println(lightGood.toString());
//		System.out.println(lightBad.toString());
//		System.out.println(soundGood.toString());
//		System.out.println(soundBad.toString());
//		System.out.println(miscGood.toString());
//		System.out.println(miscBad.toString());
//		System.out.println(moistureGood.toString());
//		System.out.println(moistureBad.toString());

		//Scanner scan = new Scanner(System.in);
		
//		System.out.println("Master List:\n" + masterList.toString());
		
		Random random = new Random();
		int randomValue = random.nextInt(masterList.size()); 

		//Check to see if no elements left.
	
		
		////////////////////////////////////////////////////////////START NOT TESTED USED QUEUE
		String str = masterList.get(randomValue);
		while(usedList.contains(str)){
//			if(usedList.size() == masterList.size()){
//				str = "Wow... My owners haven't reset me in a long time... #abandoned";
//				break;
//			}
			
			randomValue = random.nextInt(masterList.size()); 
			str = masterList.get(randomValue);
//			System.out.println("Random:\n" + masterList.get(randomValue));
			
		}
		///////////////////////////////////////////////////////////END NOT TESTED USED QUEUE
		

		return str;
	}

}
