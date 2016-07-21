package com.tgb.lk.demo.gson.test3;

import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GsonTest3 {

	public static void main(String[] args) {
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization()
				.create();

		Map<Point, String> map1 = new LinkedHashMap<Point, String>();// 使用LinkedHashMap将结果按先进先出顺序排列
		map1.put(new Point(5, 6), "a");
		map1.put(new Point(8, 8), "b");
		String s = gson.toJson(map1);
		System.out.println(s);// 结果:[[{"x":5,"y":6},"a"],[{"x":8,"y":8},"b"]]

		Map<Point, String> retMap = gson.fromJson(s,
				new TypeToken<Map<Point, String>>() {
				}.getType());
		for (Point p : retMap.keySet()) {
			System.out.println("key:" + p + " values:" + retMap.get(p));
		}
		System.out.println(retMap);

		System.out.println("----------------------------------");
		Map<String, Point> map2 = new LinkedHashMap<String, Point>();
		map2.put("a", new Point(3, 4));
		map2.put("b", new Point(5, 6));
		String s2 = gson.toJson(map2);
		System.out.println(s2);

		Map<String, Point> retMap2 = gson.fromJson(s2,
				new TypeToken<Map<String, Point>>() {
				}.getType());
		for (String key : retMap2.keySet()) {
			System.out.println("key:" + key + " values:" + retMap2.get(key));
		}

	}
}
