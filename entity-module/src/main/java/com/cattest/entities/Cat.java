package com.cattest.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cat {

	private String name;
	private int age;
	
	@Override
	public String toString() {
		return this.name;
	}
    public Cat(String name, Integer age){
		super();
		this.name = name;
		this.age = age;
	}
}
