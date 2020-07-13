
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Main {

    public static void main(String[] args) throws IOException {
        Map<String, Organization> organizationMap = new HashMap<>();
        final ObjectMapper mapper = new ObjectMapper();
        try {
            List<Organization> organizations = mapper.readValue(new File("data.json"), new TypeReference<>() {});
            for (Organization org : organizations){
                organizationMap.put(org.getNameShort(),org);

            }
        }
        catch (IOException e ){
            e.printStackTrace();
        }
        for (Map.Entry<String, Organization> map : organizationMap.entrySet()){
            System.out.println(map);
        }
        //JSON parser object to parse read file
//        JSONParser jsonParser = new JSONParser();
//        try (FileReader reader = new FileReader("data.json")) {
//            //Read JSON file
//            Object obj = jsonParser.parse(reader);
//
//            JSONArray orgs = (JSONArray) obj;
//            System.out.println(orgs);
//
//            //Iterate over employee array
//            orgs.forEach(emp -> parseOrg((JSONObject) emp));
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
    }

    private static void parseOrg(JSONObject org) {
        JSONObject orgObject = (JSONObject) org.get("org");

        String nameShort = (String) orgObject.get("nameShort");

        String nameFull = (String) orgObject.get("nameFull");

        String address = (String) orgObject.get("address");

        String numberPhone = (String) orgObject.get("numberPhone");

        String dateOfEstablishment = (String) orgObject.get("dateOfEstablishment");

        String inn = (String) orgObject.get("inn");

        String number = (String) orgObject.get("number");

        String ogrn = (String) orgObject.get("ogrn");

        JSONObject cennieBumagiObject = (JSONObject) org.get("cennieBumagi");

        String code = (String) cennieBumagiObject.get("code");

        String dateOfEnd = (String) cennieBumagiObject.get("dateOfEnd");

        String nameOfOwner = (String) cennieBumagiObject.get("nameOfOwner");

        String money = (String) cennieBumagiObject.get("money");

        String id = (String) cennieBumagiObject.get("id");

    }

}

