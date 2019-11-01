package com.intech.spring.beanfactory;

import org.springframework.beans.BeanUtils;

public class BeanFactory {

	public static <T> T build(Class<T> clazz, Object object) throws InstantiationException, IllegalAccessException {

		T t = clazz.newInstance();
		BeanUtils.copyProperties(object, t);
		return t;
	}
}
