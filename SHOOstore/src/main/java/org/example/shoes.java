package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

public class shoes implements Comparable<shoes> {
    String name;
    String company;
    String date;
    int amount;
    double price;



    public static shoes GetShoeFromLine(String line){
        var shoe = new shoes();
        StringTokenizer stringTokenizer = new StringTokenizer(line, "\t\r ");
        String nameShoe = "";
        String compName = "";
        while(stringTokenizer.hasMoreTokens()){
            var str = stringTokenizer.nextToken();

            if (IsName(str)){
                nameShoe = str;
            }
            else if (IsCompany(str)) {
                compName = str;
            }
            else if (IsAmount(str)){
                shoe.setAmount(Integer.parseInt(str));
            }
            else if(IsPrice(str)){
                shoe.setPrice(Double.parseDouble(str));
            }
            else if(IsDate(str)){
                shoe.setDate(str);
            }

        }
        shoe.setName(nameShoe + compName);
        return shoe;
    }


    public static boolean IsName(String name){
        return name.matches("\"[\\S]+\"");
    }

    public static boolean IsCompany(String company){
        return company.matches("\\([\\S]+\\)");
    }


    public static boolean IsAmount(String amount){
        return amount.matches("[1-9]|[1-9][0-9]|100");
    }

    public static boolean IsPrice(String price){

        return price.matches("[1-9][0-9]*\\.[0-9][0-9]");
    }

    public  static boolean IsDate(String date){

        return date.matches("(0[1-9]|1[0-2])\\.202[0-2]");
    }
    public String getName() {
        StringBuilder realName = new StringBuilder();
        realName.append("\"");
        for(int i =0; i < name.length();i++){
            if(name.charAt(i) == '\"'){
                i++;
                while(name.charAt(i) != '\"'){
                    realName.append(name.charAt(i));
                    i++;
                }
            }
        }
        realName.append("\"");
        return realName.toString();
    }

    public String getCompanyName(){
        StringBuilder realName = new StringBuilder();
        realName.append("(");
        for(int i =0; i < name.length();i++){
            if(name.charAt(i) == '('){
                i++;
                while(name.charAt(i) != ')'){
                    realName.append(name.charAt(i));
                    i++;
                }
            }
        }
        realName.append(")");
        return realName.toString();
    }

    public String getCompany(){
        StringBuilder realName = new StringBuilder();
        realName.append("(");
        for(int i =0; i < company.length();i++){
            if(company.charAt(i) == '('){
                i++;
                while(company.charAt(i) != ')'){
                    realName.append(company.charAt(i));
                    i++;
                }
            }
        }
        realName.append(")");
        return realName.toString();
    }


    public int getYear(){
        return LocalDate.parse("01." + getDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy")).getYear();
    }
    @Override
    public int compareTo(shoes o) {
        return this.getName().compareTo(o.getName());
    }
    public void print(){
        System.out.println(this.getName() + " " + this.getCompanyName() +" " + date + " " + amount + " " + price);
    }




    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



}
