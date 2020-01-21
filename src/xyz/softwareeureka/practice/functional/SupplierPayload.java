package xyz.softwareeureka.practice.functional;

import java.util.function.Supplier;

public class SupplierPayload<T>
{
	
	private SupplierPayload(){}
	
	public static <T> Supplier<T> setLazyVariable(final T toLazyLoad) 
	{
		return () -> 
		{
			System.out.println("(Supplier)Loading lazy variable...");
			return toLazyLoad;
		}; 
	};
	
}
