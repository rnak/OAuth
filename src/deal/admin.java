package deal;


import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class admin {
@Persistent
@PrimaryKey
private String eid;
@Persistent
private String one;
@Persistent
private String two;
@Persistent
private String three;
@Persistent
private String four;
@Persistent
private String five;
public String getEid() {
	return eid;
}
public void setEid(String eid) {
	this.eid = eid;
}
public String getOne() {
	return one;
}
public void setOne(String one) {
	this.one = one;
}
public String getTwo() {
	return two;
}
public void setTwo(String two) {
	this.two = two;
}
public String getThree() {
	return three;
}
public void setThree(String three) {
	this.three = three;
}
public String getFour() {
	return four;
}
public void setFour(String four) {
	this.four = four;
}
public String getFive() {
	return five;
}
public void setFive(String five) {
	this.five = five;
}
}

