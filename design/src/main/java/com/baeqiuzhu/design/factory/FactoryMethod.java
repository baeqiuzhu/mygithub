package com.baeqiuzhu.design.factory;
/**
 * 简单工厂模式
 */
import com.baeqiuzhu.design.ISender;
import com.baeqiuzhu.design.impl.MailSender;
import com.baeqiuzhu.design.impl.SmsSender;

public class FactoryMethod {

	public static final String METHORD_SMS = "SMS";
	public static final String METHORD_MAIL = "MAIL";
	
	public ISender produce(String type) {
		if(METHORD_SMS.equalsIgnoreCase(type)) {
			return new SmsSender();
		} else if (METHORD_MAIL.equalsIgnoreCase(type)) {
			return new MailSender();
		} else {
			System.out.println("请选择正确的类型！");
			return null;
		}
	}
	
}
