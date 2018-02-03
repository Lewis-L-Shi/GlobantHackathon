
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class JsonParser {
    private JSONObject jsonObj;
    public JsonParser(JSONObject JSONObj){
        jsonObj = JSONObj;
    }
    public List<String> ConvertJSONtoList(){
        //List<Character> charList = new ArrayList<Character>();
        List<String> itemList = new ArrayList<String>();
        try{
            //List<ArrayList<String>> itemList = new ArrayList<ArrayList<String>>();
            
            JSONArray jRegions = jsonObj.getJSONArray("regions");
            JSONObject firstObj = jRegions.getJSONObject(0);
            JSONArray jLines = firstObj.getJSONArray("lines");
            for(int i=0; i< jLines.length(); i++){
                JSONObject jLfirstObj = jLines.getJSONObject(i);
                //ArrayList<String> lineList = new ArrayList<String>();
                String line = "";
                JSONArray jWords = jLfirstObj.getJSONArray("words");
                for(int j=0; j<jWords.length(); j++){
                    JSONObject jWfirstObj = jWords.getJSONObject(j);
                    String fchar = jWfirstObj.get("text").toString();
                    line = line + fchar;
                    //lineList.add(fchar);
                }
                itemList.add(line);
            }
            
            //JSONObject jLfirstObj = jLines.getJSONObject(0);
            //JSONArray jWords = jLfirstObj.getJSONArray("words");
            //JSONObject jWfirstObj = jWords.getJSONObject(0);
            //String fchar = jWfirstObj.get("text").toString();
            //JOptionPane.showMessageDialog(null, itemList.toString());
            
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }
        return itemList;
    }            
}
