package com.tgb.lk.demo.gson.test6;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonTest6 {

	public static void main(String[] args) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(PackageState.class,
				new EnumSerializer());
		Gson gson = gsonBuilder.create();
		PackageItem item = new PackageItem();
		item.setName("item_name");
		item.setSize("500M");
		item.setState(PackageState.UPDATING);// 这个 state是枚举值

		String s = gson.toJson(item);
		System.out.println(s);

		System.out.println("--------------------------------");

		PackageItem retItem = gson.fromJson(s, PackageItem.class);
		System.out.println(retItem);
	}
}
