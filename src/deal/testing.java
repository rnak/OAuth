package deal;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class testing {
@Persistent
private String username;
@Persistent
private String paswrd;
@Persistent
@PrimaryKey
private String eid;
@Persistent
private String phno;
@Persistent
private String skypeid;
@Persistent
private double imgid;
@Persistent
private String lastname;
@Persistent
private String imgurl;
public String getImgurl() {
	return imgurl;
}
public void setImgurl(String imgurl) {
	this.imgurl = imgurl;
}
public double getImgid() {
	return imgid;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public void setImgid(double imgid) {
	this.imgid = imgid;
}
public String getSkypeid() {
	return skypeid;
}
public void setSkypeid(String skypeid) {
	this.skypeid = skypeid;
}
public String getPhno() {
	return phno;
}
public void setPhno(String phno) {
	this.phno = phno;
}
public String getEid() {
	return eid;
}
public void setEid(String eid) {
	this.eid = eid;
}
public String getUserName() {
	return username;
}
public void setUserName(String name) {
	username = name;
}
public String getPaswrd() {
	return paswrd;
}
public void setPaswrd(String pwd) {
	paswrd = pwd;
}

}
