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
public class Customer extends Person implements Comparable<Customer>{
    private String customerID, grossSales;
    public Customer(String cid, String gs, String fn, String ln, String adr, String ct, String st, String zp){
        super(fn, ln, adr, ct, st, zp);
        this.customerID = cid;
        this.grossSales = gs;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getGrossSales() {
        return grossSales;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setGrossSales(String grossSales) {
        this.grossSales = grossSales;
    }
    
    public String toString(){
        String output = "CustomerID:\t"+customerID+"\n"+"GrossSales:\t"+grossSales+"\n";
        output += super.toString();
        return output;
    }
    public String toCSV(){
        String output = customerID+","+grossSales+",";
        output += super.toCSV();
        return output;
    }
    public void copy(Customer c){
        super.copy(c.getFirstName(),c.getLastName(),c.getAddress(),c.getCity(),c.getState(),c.getZipcode());
        this.customerID = c.customerID;
        this.grossSales = c.grossSales;
    }
    public void copy(String cid, String gs,String fn, String ln, String adr, String ct, String st, String zp){
        super.copy(fn,ln,adr,ct,st,zp);
        this.customerID = cid;
        this.grossSales = gs;
                
    }
    public Person clone(){
        Customer c = new Customer(this.customerID, this.grossSales, super.getFirstName(), super.getLastName(), super.getAddress(), super.getCity(), super.getState(), super.getZipcode());
        return c;
    }
    public int compareTo(Customer c){
        return this.customerID.compareTo(c.customerID);
    }
    public void copyCSV(String csv){
        String [] arrayOfFields = csv.split(",");
        String cid = arrayOfFields[0];
        String gs = arrayOfFields[1];
        String fn = arrayOfFields[2];
        String ln = arrayOfFields[3];
        String adr = arrayOfFields[4];
        String ct = arrayOfFields[5];
        String st = arrayOfFields[6];
        String zp = arrayOfFields[7];
        
        copy(cid, gs,fn,ln,adr,ct,st,zp);
    }
}
