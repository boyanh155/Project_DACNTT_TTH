package com.k19.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Register")
public class Register {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String code;
    private String firstName;
    private String lastName;
    private String role;  // user, admin, seller
    private String gentle;
    private String gmail;
    private String passWord;
    private String contact;
    private String avt;
    public Register(){
        super();
        this.code=code;
        this.firstName = firstName;
        this.lastName=lastName;
        this.role = role;
        this.gentle=gentle;
        this.gmail=gmail;
        this.passWord=passWord;
        this.contact=contact;
        this.avt= avt;
    }
    public Register(String code,String firstName,String lastName,String role,String gentle, String email,String password,String contact,String avt) {
		super();
		this.code = code;
		this.firstName=firstName;
		this.lastName=lastName;
        this.role=role;
		this.gentle=gentle;
		this.gmail = email;
		this.passWord = password;
		this.contact=contact;
        this.avt=avt;
	}
    public void setCode(String code){
        this.code=code;
    }
    public String getCode(){
        return this.code;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return this.id;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void setRole(String role){
        this.role=role;
    }
    public String getRole(){
        return this.role;
    }
    public void setGentle(String gentle){
        this.gentle=gentle;
    }
    public String getGentle(){
        return this.gentle;
    }
    public void setGmail(String gmail){
        this.gmail=gmail;
    }
    public String getGmail(){
        return this.gmail;
    }
    public void setPassWord(String passWord){
        this.passWord = passWord;
    }
    public String getPassWord(){
        return this.passWord;
    }
    public void setContact(String contact){
        this.contact=contact;
    }
    public String getContact(){
        return this.contact;
    }
    public void setAvt(String avt){
        this.avt=avt;
    }
    public String getAvt(){
        return this.avt;
    }
}
