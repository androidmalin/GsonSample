package com.tgb.lk.demo.gson.test6;

public class PackageItem {
	private String name;
	private PackageState state;
	private String size;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PackageState getState() {
		return state;
	}

	public void setState(PackageState state) {
		this.state = state;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "PackageItem [name=" + name + ", size=" + size + ", state="
				+ state + "]";
	}
}