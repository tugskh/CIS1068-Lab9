/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis1068lab09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.NullPointerException;

/**
 *
 * @author tugsbilegkhaliunbat
 */
public class CustomerList {
    private Customer[] customers;
    private int size;
    
    public CustomerList(){
        customers = new Customer[4];
    }
    
    public int size(){
        return size;
    }
    public Customer get(int i){
        return customers[i];
    }
    
    public Boolean set(Customer c, int i){
        if(i<customers.length){
            customers[i] = c;
            return true;
        }
        return null;
    }
    
    public void add(Customer c){
        if(size == customers.length){
            Customer[] temp = new Customer[customers.length*2];
            for(int i = 0 ; i<customers.length; i++){
                temp[i] = customers[i];
            }
            customers = temp;
        }
        customers[size]=c;
        size++;
    }
    
    public Customer remove(int i){
        if(i<customers.length){
            Customer c = customers[i];
            for(int j = i; j<customers.length; j++)
                customers[i]=customers[i+1];
            return c;
        }
        return null;
    }
    
    public String toString(){
        int grossSalesSum = 0;
        String output = "";
        for(Customer c : this.customers){
            if(c != null){
                String gs = c.getGrossSales();
                int gsNew = Integer.valueOf(gs);
                grossSalesSum += gsNew;
                output += c.toString()+"\n";
            }
        }
        output += "\nGrossSales Sum of all the customers: "+grossSalesSum;
        return output;
    }
    
    public static CustomerList read(String fn) throws FileNotFoundException{
        CustomerList cl = new CustomerList();
        File file = new File(fn);
        Scanner sc = new Scanner(file);
        sc.nextLine();
        while(sc.hasNext()){
            Customer c = new Customer("","","","","","","","");
            String csv = sc.nextLine();
            c.copyCSV(csv);
            cl.add(c);
        }
        return cl;
    }
    public static Boolean write(CustomerList cl, String fn) throws IOException{
        File file = new File(fn);
        FileWriter fw = new FileWriter(file);
        int t =0;
        for(int i = 0; i<cl.size(); i++){
            fw.write(cl.get(i).toCSV());
            t++;
        }
        fw.close();
        return t != 0;
    }
    public  void sort(){
        if(customers != null){
            int min = 0;
            for(int i = 0; i<customers.length-1; i++){
                min = i;
                for(int j = i+1; j<customers.length; j++){
                    if(customers[j]!=null){
                        if(Integer.valueOf(customers[j].getCustomerID())< Integer.valueOf(customers[min].getCustomerID()))
                           min = j;
                    }
                }
                Customer temp = customers[min];
                customers[min] = customers[i];
                customers[i] = temp;
            }
        }
    }
        
    
    
    public int indexOf(int id){
        int min = 0;
        int mid = 0;
        int max = customers.length-1;
                while(min<=max){
                mid = (min+max)/2;
                if(customers[mid]!= null && customers[mid].getCustomerID()!= null){
                    if(Integer.valueOf(customers[mid].getCustomerID())<id){
                        min = mid +1;
                    }
                    else if(Integer.valueOf(customers[mid].getCustomerID())>id){
                        max = mid -1;
                    }
                    else{
                        return mid;
                    }
                }
            }
        return -(mid+1);
    }
    
    public  int binarySearch(int id){
        int min = 0;
        int max = customers.length-1;
        return binarySearch(id, min, max);
    }
    public int binarySearch(int id, int min, int max){
        if(min>max)
            return -min-1;
        int mid = (min+max)/2;
        if(customers[mid]!=null){
            if(Integer.valueOf(customers[mid].getCustomerID())>id)
                max = mid - 1;
            if(Integer.valueOf(customers[mid].getCustomerID())<id)
                min = mid+1;
            else if(Integer.valueOf(customers[mid].getCustomerID())==id)
                return mid;
        }
        return binarySearch(id, min, max);
    }
    

    
    
    public Boolean update(int id, int amount){
        if(indexOf(id)>0){
            customers[indexOf(id)].setGrossSales(String.valueOf(Integer.valueOf(customers[indexOf(id)].getGrossSales())+amount));
            return true;
        }
        return false;
    }
    
    
}
