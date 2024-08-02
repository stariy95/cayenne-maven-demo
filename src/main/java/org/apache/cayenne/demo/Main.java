package org.apache.cayenne.demo;

import java.time.LocalDate;
import java.util.List;

import com.mysql.cj.jdbc.Driver;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.datasource.DataSourceBuilder;
import org.apache.cayenne.demo.model.Artist;
import org.apache.cayenne.demo.model.Gallery;
import org.apache.cayenne.demo.model.Painting;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.cayenne.runtime.CayenneRuntime;

public class Main {

    public static void main(String[] args) {

        // starting Cayenne
        CayenneRuntime cayenneRuntime = CayenneRuntime.builder()
                .addConfig("cayenne-project.xml")
                .dataSource(DataSourceBuilder
                        .url("jdbc:mysql://localhost/demo?nullNamePatternMatchesAll=true")
                        .driver(Driver.class.getName())
                        .userName("root")
                        .password("testpwd")
                        .pool(1, 5)
                        .build())
                .build();

        // getting a hold of ObjectContext
        ObjectContext context = cayenneRuntime.newContext();

        newObjectsTutorial(context);
        selectTutorial(context);
        deleteTutorial(context);
    }

    static void newObjectsTutorial(ObjectContext context) {

        // creating new Artist
        Artist picasso = context.newObject(Artist.class);
        picasso.setName("Pablo Picasso");
        picasso.setDateOfBirth(LocalDate.of(1881, 10, 25));

        // Creating other objects
        Gallery metropolitan = context.newObject(Gallery.class);
        metropolitan.setName("Metropolitan Museum of Art");

        Painting girl = context.newObject(Painting.class);
        girl.setName("Girl Reading at a Table");

        Painting stein = context.newObject(Painting.class);
        stein.setName("Gertrude Stein");

        // connecting objects together via relationships
        picasso.addToPaintings(girl);
        picasso.addToPaintings(stein);

        girl.setGallery(metropolitan);
        stein.setGallery(metropolitan);

        // saving all the changes above
        context.commitChanges();
    }

    static void selectTutorial(ObjectContext context) {
        // SelectQuery examples
        List<Painting> paintings1 = ObjectSelect
                .query(Painting.class)
                .select(context);

        List<Painting> paintings2 = ObjectSelect
                .query(Painting.class, Painting.NAME.likeIgnoreCase("gi%"))
                .select(context);

        List<Painting> paintings3 = ObjectSelect
                .query(Painting.class)
                .where(Painting.ARTIST.dot(Artist.DATE_OF_BIRTH).lt(LocalDate.of(1900, 1, 1)))
                .select(context);

    }

    static void deleteTutorial(ObjectContext context) {

        Artist picasso = ObjectSelect
                .query(Artist.class, Artist.NAME.eq("Pablo Picasso"))
                .selectOne(context);

        if (picasso != null) {
            List<Painting> picassoPaintings = ObjectSelect
                    .query(Painting.class, Painting.ARTIST.eq(picasso))
                    .select(context);
            context.deleteObjects(picassoPaintings);
            context.deleteObjects(picasso);
            context.commitChanges();
        }
    }

}
