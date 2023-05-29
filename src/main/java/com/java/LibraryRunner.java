package com.java;

import com.java.model.Document;
import com.java.model.Library;
import com.java.services.random_service.RandomService;

import java.util.ArrayList;
import java.util.List;

public class LibraryRunner {
    public static void main(String[] args) throws Exception {

        RandomService randomService = new RandomService();

        Library libraryWarszawa = new Library("Warszawa", 5, null);
        List<Document> documentList1 = new ArrayList<>();

        for (int i = 0; i < libraryWarszawa.getMaxBookAmount() - 1; i++) {
            documentList1.add(randomService.getRandomDocument());
        }

        libraryWarszawa.setDocuments(documentList1);

        ////////////////////////////////////////

        Library libraryKoszalin = new Library("Koszalin", 5, null);
        List<Document> documentList2 = new ArrayList<>();

        for (int i = 0; i < libraryKoszalin.getMaxBookAmount(); i++) {
            documentList2.add(randomService.getRandomDocument());
        }

        libraryKoszalin.setDocuments(documentList2);

        ////////////////////////////////////////


        Library libraryPoznan = new Library("Poznan", 5, null);
        List<Document> documentList3 = new ArrayList<>();

        for (int i = 0; i < libraryWarszawa.getMaxBookAmount(); i++) {
            documentList3.add(randomService.getRandomDocument());
        }

        libraryPoznan.setDocuments(documentList3);

        ////////////////////////////////////////


        Document randomDocument = randomService.getRandomDocument();

        System.out.println(libraryWarszawa.getDocuments().size());
        System.out.println(libraryWarszawa.save(randomDocument));
        System.out.println(libraryWarszawa.getDocuments().size());
        System.out.println(libraryWarszawa.delete(libraryWarszawa.getDocuments().get(2)));
        System.out.println(libraryWarszawa.getDocuments().size());

        libraryPoznan.read(libraryPoznan.getDocuments().get(3));


    }
}