package DSA5_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.LinkedHashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSON
{
	private static LinkedHashMap<Object,Object> dictMap = new LinkedHashMap<Object, Object>();

	public static LinkedHashMap<Object, Object> getDictMap() {
		return dictMap;
	}

	@SuppressWarnings("unchecked")
	public static void readJSON() 
	{
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("..\\dictionaryPairs.json"))
		{
			Object obj = jsonParser.parse(reader);

			JSONArray list = (JSONArray) obj;
			System.out.println(list);

			list.forEach( dict -> parseDictionaryObject( (JSONObject) dict ) );

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void parseDictionaryObject(JSONObject dict) 
	{
		JSONObject dictObject = (JSONObject) dict.get("pair");

		Object key = (Object) dictObject.get("key");
		Object value = (Object) dictObject.get("value");
		dictMap.put(key, value);
	}
}
