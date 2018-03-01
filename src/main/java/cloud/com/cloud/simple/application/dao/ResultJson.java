package cloud.com.cloud.simple.application.dao;

import java.io.Serializable;

/**
 * 返回JSON实体
 * @author zhongxin
 * @version 1.0
 */
public class ResultJson implements Serializable{

	/**
	 * 版本号
	 */
	private static final long serialVersionUID = 4930662775738842538L;

	/**app版本*/
	private String apkSerial;
	
	/**app跳转链接*/
	private String apkUrl;
	
	/**应用名称*/
	private String apkTitle;
	
	/**应用是否打开开关  1. 是  2 否*/
	private int apkState;

	public String getApkSerial() {
		return apkSerial;
	}

	public void setApkSerial(String apkSerial) {
		this.apkSerial = apkSerial;
	}

	public String getApkUrl() {
		return apkUrl;
	}

	public void setApkUrl(String apkUrl) {
		this.apkUrl = apkUrl;
	}

	public String getApkTitle() {
		return apkTitle;
	}

	public void setApkTitle(String apkTitle) {
		this.apkTitle = apkTitle;
	}

	public int getApkState() {
		return apkState;
	}

	public void setApkState(int apkState) {
		this.apkState = apkState;
	}
	
	
}