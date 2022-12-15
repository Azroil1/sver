import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\Amir\\Downloads\\Задача ВС Java Сбер.csv";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter(System.getProperty("line.separator"));
        List<City> list = new ArrayList<>();
        List<City> list1 = new ArrayList<>();
        while(scanner.hasNextLine()){
//            System.out.println(scanner.next());
            City city = parseCSVLine(scanner.next());
//            System.out.println(city.toString());
            list.add(city);
            list1.add(city);
        }
        Collections.sort(list,City.NameComparator);
        Collections.sort(list1, City.DistrictComparator);
        for(City e : list){
            System.out.println(e);
        }
        for(City a: list1){
            System.out.println(a);
        }
        scanner.close();

    }

    private static City parseCSVLine(String line) throws NoSuchElementException {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter("\\s*;\\s*");
        String number = scanner.next();
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        String population = scanner.next();
        String foundation = null;
        if (scanner.hasNext()) {
            foundation = scanner.next();
        }
        Main main = new Main();
        return main.new City(name, region, district, population, foundation);
    }


    public class City implements Comparable<City>{
        private String name;
        private String region;
        private String district;
        private String population;
        private String foundation;

        public String getName() {
            return name;
        }

        public String getDistrict() {
            return district;
        }

        public City (String name, String region, String district, String population, String foundation){
            this.name = name;
            this.region = region;
            this.district = district;
            this.population = population;
            this.foundation = foundation;
        }


        public String toString(){
            return "City" + "{" + "name = " +  "'" + this.name+ "'" +
                    ",region = " + "'" + this.region  + "'" +
                    ",district = " + "'" + this.district + "'" +
                    ",population = " + "'" + this.population + "'" +
                    ",foundation = " + "'" + this.foundation + "'" + "}";
        }


        @Override
        public int compareTo(City o) {

            return this.name.compareTo(o.getName());
        }
        public static Comparator<City> NameComparator = new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        public static Comparator<City> DistrictComparator = new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                if(o1.getDistrict().compareTo(o2.getDistrict()) == 0){
                    return o1.getName().compareTo(o2.getName());
                }
                return o1.getDistrict().compareTo(o2.getDistrict());
            }
        };
    }

}
