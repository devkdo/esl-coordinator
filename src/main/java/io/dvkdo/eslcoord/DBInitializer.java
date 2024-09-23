package io.dvkdo.eslcoord;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

@ApplicationScoped
public class DBInitializer {

    @Inject
    @ConfigProperty(name = "eslcoord.schema.create", defaultValue = "false")
    boolean schemaCreate;

    @Inject
    DataSource dataSource;

    void onStart(@Observes StartupEvent ev) {

        if (schemaCreate)
            initdb();
    }

    private void initdb() {

        System.out.println("Init DB");

        try (Connection connection = dataSource.getConnection()) {

            try (Statement stmt = connection.createStatement()) {

                stmt.execute("DROP TABLE IF EXISTS particles");

                stmt.execute("CREATE TABLE particles (name VARCHAR(255))");

                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS rowcount FROM particles");

                rs.next();

                System.out.println("Table contains " + rs.getInt("rowcount") + " rows");

            } catch (SQLException e) {
                System.out.println("Error processing statement " + e);
            }

        } catch (SQLException e) {
            System.out.println("Error processing connection " + e);
        }
    }

}