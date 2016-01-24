package com.baeqiuzhu.design.factory;

import com.baeqiuzhu.design.impl.MailSender;
import com.baeqiuzhu.design.impl.SmsSender;
import com.baeqiuzhu.design.ISender;

public class MultiFactoryMethod {

	/**
	 * 
	 * @return
	 */
	public ISender produceMailSender(){
		return new MailSender();
	}
	
	public ISender produceSmsSender(){
		return new SmsSender();
	}
	
}
