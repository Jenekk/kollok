package org.example;


import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

public class shoesList {

    List<shoes> shos = new ArrayList<>();

    public shoesList(String inputFileName) throws FileNotFoundException {
        var scanner = new Scanner(new File(inputFileName));
        var size = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < size; i++) {
            var medicineLine = scanner.nextLine();
            shos.add(shoes.GetShoeFromLine(medicineLine));

        }

    }


    public void sortByName(){
        shos.sort((a,b) -> a.getName().compareTo(b.getName()));
    }

    public shoes binarySearch(String name)
    {
        ArrayList<String> names = new ArrayList<>();
        for (shoes it: shos)
        {
            names.add(it.getName());
        }
        int index = Arrays.binarySearch(names.toArray(), name);

        if (index != -1)
        {
            return shos.get(index);
        }
        else
        {
            return null;
        }
    }


    public void sortByPrice(){
        shos.sort((a,b) -> Double.compare(a.getPrice(),b.getPrice()));
    }

    public void filterByYear( int year) throws ParseException {

            shos.stream()
                    .filter(x -> x.getYear() == year).forEach(shoes::print);
    }

    public void groupByDate(){
       shos.stream().collect(Collectors.groupingBy(shoes::getYear)).forEach((year, shos) -> {
           System.out.println(year);
           shos.forEach(shoes::print);
       });
    }

}
