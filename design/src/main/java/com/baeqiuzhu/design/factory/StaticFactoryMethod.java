package com.baeqiuzhu.design.factory;

import com.baeqiuzhu.design.impl.MailSender;
import com.baeqiuzhu.design.impl.SmsSender;

import org.apache.commons.lang3.StringUtils;

import com.baeqiuzhu.design.ISender;

public class StaticFactoryMethod {

	/**
	 * 
	 * @return
	 */
	public static ISender produceMailSender(){
		return new MailSender();
	}
	
	public static ISender produceSmsSender(){
		return new SmsSender();
	}
	
	/**
	 * 利用反射机制，动态创建
	 * @return
	 */
	public static ISender getInstance(String className) {
		ISender sender = null;
		if(StringUtils.isNotBlank(className) && null == sender) {
			try {
				sender = (ISender) Class.forName(className).newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return sender;
	}
	
}
