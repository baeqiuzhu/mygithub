package com.baeqiuzhu.design.factory;

import com.baeqiuzhu.design.ISender;
import com.baeqiuzhu.design.impl.SmsSender;

public class AbstractSmsFactory implements IAbstactFactoryMethod {

	public ISender produce() {
		return new SmsSender();
	}

}
