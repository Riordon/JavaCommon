package xstream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

public class Person {
	@XStreamAlias("username")
	private String name;
	private int age;
	private String addr;
	
	@XStreamOmitField 
	private Phone phone;
	
	public Person(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("Person", Person.class);
		
		Person person = new Person("xiaolong",25,"湖北黄石");
		person.setPhone(new Phone("18772316081"));
		
		xstream.processAnnotations(person.getClass());  //注解需要加这个
		String xml = xstream.toXML(person);
		System.out.println(xml);
		
//		File file = new File("PersonBean.txt");
//		FileWriter fileWriter = new FileWriter(file, true);
//		
//		BufferedWriter buffer = new BufferedWriter(fileWriter);
//		buffer.write(xml);
//		buffer.close();
		
//		Person obj = (Person) xstream.fromXML(file);
//		
//		System.out.println(obj.name);
//		System.out.println(obj.addr);
	}
}


class Phone {
	public String phone;
	
	public Phone(String phone) {
		this.phone = phone;
	}
}