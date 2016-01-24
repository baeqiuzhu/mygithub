package com.baeqiuzhu.design.factory;

import com.baeqiuzhu.design.ISender;
import com.baeqiuzhu.design.impl.MailSender;

public class AbstractMailFactory implements IAbstactFactoryMethod {

	public ISender produce() {
		return new MailSender();
	}

}
