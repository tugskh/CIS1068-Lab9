/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis1068lab09;

/**
 *
 * @author tugsbilegkhaliunbat
 */
public class Person {
    private String firstName, lastName, address, city, state, zipcode;
    public Person(String fn, String ln, String adr, String ct, String st, String zp){
        this.firstName = fn;
        this.lastName = ln;
        this.address = adr;
        this.city = ct;
        this.state = st;
        this.zipcode = zp;
    }

    public Person(String lastName, String address, String city, String state, String zipcode) {
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String fn){
        this.firstName = fn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    public void copy(Person p){
       this.firstName = p.firstName;
       this.lastName = p.firstName;
       this.address = p.address;
       this.city = p.city;
       this.state = p.state;
       this.zipcode = p.zipcode;
    }
    public void copy(String fn, String ln, String adr, String ct, String st, String zp){
        this.firstName = fn;
        this.lastName = ln;
        this.address = adr;
        this.city = ct;
        this.state = st;
        this.zipcode = zp;
    }
    
    public Person clone(){
        Person p = new Person(this.firstName, this.lastName, this.address, this.city,this.state, this.zipcode);
        return p;
    }
    
    public String toCSV(){
        String csv = firstName+","+lastName+","+address+","+city+","+state+","+zipcode+"\n";
        return csv;
    }
    
    public String toString(){
        String output = "FirstName:\t"+this.firstName+"\n"+"LastName:\t"+this.lastName+"\n"+"Address:\t"+this.address+"\n"+"City:\t\t"+this.city+"\n"+"State:\t\t"+this.state+"\n"+"Zipcode:\t"+this.zipcode+"\n";
        return output;
    }
    
    
}
