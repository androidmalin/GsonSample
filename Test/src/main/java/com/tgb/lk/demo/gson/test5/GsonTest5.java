package com.tgb.lk.demo.gson.test5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonTest5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 对象转为Json-->start
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

		TableData td1 = new TableData();
		td1.setTableName("students");
		td1.setTableData(stulist);

		TableData td2 = new TableData();
		td2.setTableName("teachers");
		td2.setTableData(teacherList);

		List<TableData> tdList = new ArrayList<TableData>();
		tdList.add(td1);
		tdList.add(td2);
		Gson gson = new Gson();
		String s = gson.toJson(tdList);

		System.out.println(s);
		// 结果:[{"tableName":"students","tableData":[{"id":1,"name":"李坤","birthDay":"Jun 22, 2012 10:44:16 AM"},{"id":2,"name":"曹贵生","birthDay":"Jun 22, 2012 10:44:16 AM"},{"id":3,"name":"柳波","birthDay":"Jun 22, 2012 10:44:16 AM"}]},{"tableName":"teachers","tableData":[{"id":1,"name":"米老师","title":"教授"},{"id":2,"name":"丁老师","title":"讲师"}]}]
		// 对象转为Json-->end

		// /////////////////////////////////////////////////////////////////////

		// 将json转为数据-->start
		List<TableData> tableDatas2 = gson.fromJson(s,
				new TypeToken<List<TableData>>() {
				}.getType());
		for (int i = 0; i < tableDatas2.size(); i++) {
			TableData entityData = tableDatas2.get(i);
			String tableName = entityData.getTableName();
			List tableData = entityData.getTableData();
			String s2 = gson.toJson(tableData);
			// System.out.println(s2);
			// System.out.println(entityData.getData());
			if (tableName.equals("students")) {
				System.out.println("students");
				List<Student> retStuList = gson.fromJson(s2,
						new TypeToken<List<Student>>() {
						}.getType());
				for (int j = 0; j < retStuList.size(); j++) {
					System.out.println(retStuList.get(j));
				}

			} else if (tableName.equals("teachers")) {
				System.out.println("teachers");
				List<Teacher> retTchrList = gson.fromJson(s2,
						new TypeToken<List<Teacher>>() {
						}.getType());
				for (int j = 0; j < retTchrList.size(); j++) {
					System.out.println(retTchrList.get(j));
				}
			}
		}

		// Json转为对象-->end
	}
}
