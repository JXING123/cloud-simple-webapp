package cloud.com.cloud.simple.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cloud.com.cloud.simple.application.service.JSONService;

/**
 * 首页控制类
 * @author 钟鑫
 * @version 1.0
 * @see cloud.com.cloud.simple.application.controller.IndexController
 */
@Controller
@RequestMapping("/")
public class IndexController{
	
	@Autowired 
	private JSONService jsonService;
	
	
	@RequestMapping("/index")
	public String index(ModelMap map){
		map.addAttribute("url","www.su8250.com");
		return "index";
	}
	
	@RequestMapping("/download")
	public String download(ModelMap map,String apkUrl){
		map.addAttribute("url","/cloud/web/apk/"+apkUrl+".apk");
		return "download";
	}
	  
	
	@ResponseBody
    @RequestMapping(value = "/getUrl")
    String getUrl() {
	    return "www.su8250.com";
	}
	  
	  
	/**
	 * 获取JSON
	 * @return
	 */
	@RequestMapping(value = "/getJson",method=RequestMethod.GET)
	@ResponseBody
	public String test(){
		String jsonData = jsonService.getData();
		return jsonData;
	}
	
	/**
	 * 读JSON
	 * @return
	 */
	@RequestMapping(value = "/readJson")
	@ResponseBody
	public String readJson(){
		String jsonData = jsonService.readJson();
		if(jsonData == null || "".equals(jsonData)){
			jsonData = "\"resuleState\":\"falil\",\"datacode\":\"004\"";
		}
		return jsonData;
	}
	
	/**
	 * 修改JSON
	 * @return
	 */
	@RequestMapping(value = "/updateJson")
	@ResponseBody
	public String updateJson(String apkSer,int apkState,String apkUrl){
		//String jsonData = jsonService.writerJson("com.redu.cn",2,"www.su808.com");
		String jsonData = jsonService.writerJson(apkSer,apkState,apkUrl);
		if(jsonData == null || "".equals(jsonData)){
			jsonData = "\"resuleState\":\"falil\",\"datacode\":\"004\"";
		}
		return jsonData;
	}
}

