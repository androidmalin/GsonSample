package com.tgb.lk.demo.gson.test4;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonTest4 {
	public static void main(String[] args) {
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("李坤");
		student1.setBirthDay(new Date());

		Student student2 = new Student();
		student2.setId(2);
		student2.setName("曹贵生");
		student2.setBirthDay(new Date());

		Student student3 = new Student();
		student3.setId(3);
		student3.setName("柳波");
		student3.setBirthDay(new Date());

		List<Student> stulist = new ArrayList<Student>();
		stulist.add(student1);
		stulist.add(student2);
		stulist.add(student3);

		Teacher teacher1 = new Teacher();
		teacher1.setId(1);
		teacher1.setName("米老师");
		teacher1.setTitle("教授");

		Teacher teacher2 = new Teacher();
		teacher2.setId(2);
		teacher2.setName("丁老师");
		teacher2.setTitle("讲师");
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList.add(teacher1);
		teacherList.add(teacher2);

		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("students", stulist);
		map.put("teachers", teacherList);

		Gson gson = new Gson();
		String s = gson.toJson(map);
		System.out.println(s);

		System.out.println("----------------------------------");

		Map<String, Object> retMap = gson.fromJson(s,
				new TypeToken<Map<String, List<Object>>>() {
				}.getType());

		for (String key : retMap.keySet()) {
			System.out.println("key:" + key + " values:" + retMap.get(key));
			if (key.equals("students")) {
				List<Student> stuList = (List<Student>) retMap.get(key);
				System.out.println(stuList);
			} else if (key.equals("teachers")) {
				List<Teacher> tchrList = (List<Teacher>) retMap.get(key);
				System.out.println(tchrList);
			}
		}

	}
}
