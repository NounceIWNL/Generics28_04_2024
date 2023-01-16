package com.company.parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class FirstParse { // Google parse searched

    /*
        https:www.google.com/search?q=text

        $x('//div') - найти все элементы div
        $x("//div[@class = 'TbwUpd']") - div с заданным классом
        $x("//div[contains(@class, 'Tbw')]") - div с классом, содержащим данную строку
        $x("//div[contains(@class, 'TbwUpd') and contains(@class, 'NJjxre')]") - div содержит два класса
        $x("//div[contains(@class, 'TbwUpd') and contains(.//cite,'')]")[0].textContent
        $x("//div[@class = 'MUFPAc']/div[2]/a")[0].innerText - Найти текст "картинки"
        $x("//table[@class = 'AaVjTc']/tbody/tr/td/a/span[not(@class)]")[0].innerText - Найти текст ссылки "Следующая"
        $x("//span[@id = 'fsl']/a")[0].innerText Найти слово справка внизу страницы
        $x("//span[@id = 'xjs']/table/tbody/tr/td[3]")[0].innerText Найти ссылку на 2 - ю страницу
        $x("//div[@id = '_U9WEYvi5H6OB9u8PkqSA-AQ7']/div/div/div/div[2]/div/a")[0].ariaLabel Вывести информацию
        об аккаунте
        $x("//div[@id = '_lNaEYrybDPf-7_UP7_qlmA45']")[0].ariaLabel Вывести слово "Настройки" (из меню)
    */

    private static Document document;
    private static final String url = "https://www.google.com/search?q=tex";
    private static final String selector = "div[@class = 'TbwUpd']>cite";

    public static void main(String[] args) {
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.err.println("Check HTTP connection to the url " + url);
        }

        System.out.println(document.html());
        Elements links = document.select(selector);
        for (Element link : links) {
            System.out.println(link.html());
        }

    }
}
