package exercise;

import java.util.concurrent.CompletableFuture;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

class App {
    private static Path getFullPath(String filePath) {
        return Paths.get(filePath).toAbsolutePath().normalize();
    }

    // BEGIN
    public static CompletableFuture<String> unionFiles(String sourceFilePath1, String sourceFilePath2, String destFilePath) {
        //1
        CompletableFuture<String> content1 = CompletableFuture.supplyAsync(() -> {
            String content = "";

            try {
                content = Files.readString(getFullPath(sourceFilePath1));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return content;
        });

        //2
        CompletableFuture<String> content2 = CompletableFuture.supplyAsync(() -> {
            String content = "";

            try {
                content = Files.readString(getFullPath(sourceFilePath2));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return content;
        });

        //Combine 2 content
        return content1.thenCombine(content2,(con1,con2) -> {
            String result = con1.trim() +" " + con2.trim();

            try {
                Files.writeString(getFullPath(destFilePath), result, StandardOpenOption.CREATE);
                return result;
            } catch (Exception e) {
                throw new RuntimeException("Error: " + e.getMessage());
            }
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return "Unknown!";
        });
        // END
    }




    public static void main (String[] args) {
        String filePath1 = "/home/maxim/Hexlet/hexlet-assignments/java-advanced-ru/asynchrony/src/main/resources/file1.txt";
        String filePath2 = "/home/maxim/Hexlet/hexlet-assignments/java-advanced-ru/asynchrony/src/main/resources/file2.txt";

        try {
            CompletableFuture<String> result = unionFiles(filePath1,filePath2,"dest.txt");
            System.out.println(result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

