package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

// BEGIN
import io.javalin.http.Context;

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}" , ctx -> {
            var companyId = ctx.pathParam("id");
            Map<String , String> company = findCompanyById(companyId);

            if(company != null) {
                ctx.json(company);
            } else {
                ctx.status(404).result("Company not found");
            }
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static Map<String,String> findCompanyById(String id) {
        return COMPANIES.stream()
                .filter(company -> company.get("id").equals(id))
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
