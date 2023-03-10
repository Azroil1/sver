import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\Amir\\Downloads\\Задача ВС Java Сбер.csv";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter(System.getProperty("line.separator"));
        List<String> list = new ArrayList<>();

        while(scanner.hasNextLine()){
            City city = parseCSVLine(scanner.next());
            list.add(city.region);
        }
        Map<String,Integer> cityInRegion = list.stream()
                        .collect(Collectors.toMap(
                                e->e,
                                e->1,
                                Integer::sum));
        cityInRegion.forEach((k,v) -> System.out.println(k  + "-" + v));
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
        int population1 = Integer.parseInt(population);
        String foundation = null;
        if (scanner.hasNext()) {
            foundation = scanner.next();
        }
        Main main = new Main();
        return main.new City(name, region, district, population, foundation, population1);
    }



    public class City{
        private String name;
        private String region;
        private String district;
        private String population;
        private String foundation;

        private int population1;

        public int getPopulation1(){
            return population1;
        }

        public String getName() {
            return name;
        }

        public String getDistrict() {
            return district;
        }
        public String getRegion(){return region;}

        public City (String name, String region, String district, String population, String foundation,int population1){
            this.name = name;
            this.region = region;
            this.district = district;
            this.population = population;
            this.foundation = foundation;
            this.population1 = population1;
        }


        public String toString(){
            return "City" + "{" + "name = " +  "'" + this.name+ "'" +
                    ",region = " + "'" + this.region  + "'" +
                    ",district = " + "'" + this.district + "'" +
                    ",population = " + "'" + this.population + "'" +
                    ",foundation = " + "'" + this.foundation + "'" + "}";
        }




    }

}
