package cloud.com.cloud.simple.application.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class JSONService {
	
	@Value(value="classpath:/rest.json")
    private  Resource data;    
    
    public String getData(){
        try {
            File file = data.getFile();
            long t0 = System.nanoTime();
            String jsonData = this.jsonRead(file);
            long t1 = System.nanoTime();
            long millis = TimeUnit.NANOSECONDS.toMillis(t1-t0);
            System.out.println(millis +"ms");
            return jsonData;
        } catch (Exception e) {
            return "未读取到JSON";
        }
    }
    /**
     *     读取文件类容为字符串
     * @param file
     * @return
     */
      private String jsonRead(File file){
            Scanner scanner = null;
            StringBuilder buffer = new StringBuilder();
            try {
                scanner = new Scanner(file, "utf-8");
                while (scanner.hasNextLine()) {
                    buffer.append(scanner.nextLine());
                }
            } catch (Exception e) {
                
            } finally {
                if (scanner != null) {
                    scanner.close();
                }
            }
            return buffer.toString();
        }
      
      
      


      	/**
      	 *  写JSON
      	 */
      	public String writerJson(String apkSer,int apkState,String apkUrl) {
      		String s = null, ws = null;
      		
      		// 读取原始json文件并进行操作和输出
      		try {
      			//BufferedReader br = new BufferedReader(new FileReader("/Users/Anthony/Documents/abc/HK_geo.json"));// 读取原始json文件
      			//BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/Anthony/Documents/abc/HK_new.json"));// 输出新的json文件
      			
      			BufferedReader br = new BufferedReader(new FileReader("D:/web/new_config/HK_geo.json"));// 读取原始json文件
      			BufferedWriter bw = new BufferedWriter(new FileWriter("D:/web/new_config/HK_new.json"));// 输出新的json文件
      			if(br != null){
      			while ((s = br.readLine()) != null) {
      				 System.out.println(s);
      				try {
      					JSONObject dataJson = new JSONObject(s);// 创建一个包含原始json串的json对象
      					JSONArray features = dataJson.getJSONArray("appMap");// 找到appMap的json数组
      					for (int i = 0; i < features.length(); i++) {
      						JSONObject info = features.getJSONObject(i);// 获取appMap数组的第i个json对象
      						String apkSerial = info.getString("apkSerial");// 读取appMap对象里的apkSerial字段值
      						System.out.println(apkSerial);
      						if(apkSer.equals(apkSerial)){
      							// 更改状态
      							info.remove("apkState");
      							info.put("apkState", apkState);
      							
      							// 更改链接
      							info.remove("apkUrl");
      							info.put("apkUrl", apkUrl);
      							
      						}
      					}
      					ws = dataJson.toString();
      					System.out.println(ws);
      				} catch (JSONException e) {
      					// TODO Auto-generated catch block
      					e.printStackTrace();
      				}
      			}

      			bw.write(ws);
      			// bw.newLine();
      			bw.flush();
      			//BufferedWriter brW = new BufferedWriter(new FileWriter("/Users/Anthony/Documents/abc/HK_geo.json"));// 原始文件写入流
      			BufferedWriter brW = new BufferedWriter(new FileWriter("D:/web/new_config/HK_geo.json"));// 原始文件写入流
      			brW.write(ws);
      			brW.flush();
      			brW.close();
      			br.close();
      			bw.close();
      			}

      		} catch (IOException e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		}
      		return ws;

      	}
      	
      	/**
      	 *  读JSON
      	 */
		public String readJson() {
      		String s = null;
      		String rs = null;
      		
      		// 读取原始json文件并进行操作和输出
      		try {
      			//BufferedReader br = new BufferedReader(new FileReader("/Users/Anthony/Documents/abc/HK_geo.json"));// 读取原始json文件
      			BufferedReader br = new BufferedReader(new FileReader("D:/web/new_config/HK_geo.json"));// 读取原始json文件
      			
      			if(br != null){
	      			while ((s = br.readLine()) != null) {
	      				 System.out.println(s);
	      				 rs = s;
	      			}
	      			
	      			br.close();
      			}

      		} catch (IOException e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		}
      		return rs;

      	}

      

}
