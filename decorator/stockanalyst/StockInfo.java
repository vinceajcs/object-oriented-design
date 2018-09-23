package stockanalyst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StockInfo {
    private String filename;
    private List<String> keywords = Arrays.asList("name", "hq", "earnings", "marketsegment", "shareprice", "products");
    private List<String> data = new ArrayList<>();
    private String name = "";
    private String hq = "";
    private Double earnings = 0.0;
    private String segment = "";
    private Double price = 0.0;
    private String products = "";

    public StockInfo(String filename) {
        this.filename = filename;
        readFile();
        parseData();
    }

    public void readFile() {
        File file = new File(filename);
        Scanner sc = null;

        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            data.add(s);
        }
    }

    //I know this is bad practice but I couldn't think of any way better...sorry!
    public void parseData() {
        List<String> words;
        for (String s : data) {
            int index = 1;
            if (s.startsWith(keywords.get(0))) {
                words = Arrays.asList(s.split(" "));
                while (words.get(index).equals("")) index++;
                name = words.get(index);

            } else if (s.startsWith(keywords.get(1))) {
                words = Arrays.asList(s.split(" "));
                while (words.get(index).equals("")) index++;
                hq = words.get(index);

            } else if (s.startsWith(keywords.get(2))) {
                words = Arrays.asList(s.split(" "));
                while (words.get(index).equals("")) index++;
                earnings = Double.parseDouble(words.get(index));

            } else if (s.startsWith(keywords.get(3))) {
                words = Arrays.asList(s.split(" "));
                while (words.get(index).equals("")) index++;
                segment = words.get(index);

            } else if (s.startsWith(keywords.get(4))) {
                words = Arrays.asList(s.split(" "));
                while (words.get(index).equals("")) index++;
                price = Double.parseDouble(words.get(index));

            } else if (s.startsWith(keywords.get(5))) {
                words = Arrays.asList(s.split(" "));
                for (String p : words) {
                    if (p.equals(keywords.get(5))) continue;
                    products += p + " ";
                }
            }
        }
    }


    public String getName() {
        return name;
    }

    public String getHQ() {
        return hq;
    }

    public double getEarnings() {
        return earnings;
    }

    public String getMarketSegment() {
        return segment;
    }

    public double getSharePrice() {
        return price;
    }

    public String getProducts() {
        return products;
    }

}
