package exercise;

import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        app.get("/" , ctx -> ctx.result("Hello World"));
        app.get("/phones" , ctx -> {
            List<String> phones = Data.getPhones();
            ctx.json(phones);
        });
        app.get("/domains" , ctx -> {
            List<String> domains = Data.getDomains();
            ctx.json(domains);
        });

        return app;
    }

    public static void main(String[] args) {

        Javalin app = getApp();
        app.start(7070);
    }
}
