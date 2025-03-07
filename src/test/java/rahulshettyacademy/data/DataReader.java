package rahulshettyacademy.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		//read json to String
	String jsonContent=	FileUtils.readFileToString(new File(System.getProperty("user.dir")+ "//src//test//java//rahulshettyacademy//data//PurchageOrder.json")
			,StandardCharsets.UTF_8);
	
	//string to hashmap
	//jackson databind dependency
	ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String, String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){	
	});
	return data;
	}
}
