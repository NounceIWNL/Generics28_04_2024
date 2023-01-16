package com.company.parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductsParser {
    private Document document;
    private final String url = "https://calorizator.ru/product/all";
    private final String selector = "div>div>table>tbody>tr"; //Добавить >td>a
    private final String selectorContent = "div>div>table>tbody>tr>td"; //Добавить :eq(3)
    //*[@id="main-content"]/div/div[1]/table[2]/tbody/tr[1]/td[3]

    private List<Product> products = new ArrayList<>();

    public boolean connect(String sPage) {
        try {
            document = Jsoup.connect(url + sPage).get();
        } catch (IOException e) {
            System.err.println("Check HTTP connection to the url " + url);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}