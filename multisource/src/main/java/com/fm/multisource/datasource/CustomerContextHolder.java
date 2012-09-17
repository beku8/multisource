package com.fm.multisource.datasource;

public class CustomerContextHolder {
	
	private static final ThreadLocal<Integer> contextHolder =
            new ThreadLocal<Integer>();
 
   public static void setCustomerType(Integer customerType) {
      contextHolder.set(customerType);
   }
 
   public static Integer getCustomerType() {
      return (Integer) contextHolder.get();
   }
 
   public static void clearCustomerType() {
      contextHolder.remove();
   }

}
